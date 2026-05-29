-- 1. 외래 키 검사 임시 해제 (에러 방지용 치트키!)
SET FOREIGN_KEY_CHECKS = 0;

-- 상품
DROP TABLE IF EXISTS product;

-- 주문
DROP TABLE IF EXISTS orders;

-- 계약
DROP TABLE IF EXISTS contract;

-- 사용자
DROP TABLE IF EXISTS member;

-- 사용자
CREATE TABLE member (
	member_id     BIGINT                      NOT NULL COMMENT '사용자 고유번호', -- 사용자 고유번호
	email         VARCHAR(100)                NOT NULL COMMENT '이메일', -- 이메일
	password      VARCHAR(255)                NOT NULL COMMENT '비밀번호', -- 비밀번호
	name          VARCHAR(50)                 NOT NULL COMMENT '사용자 실명', -- 사용자 실명
	phone         VARCHAR(20)                 NULL     COMMENT '연락처', -- 연락처
	user_type     ENUM('PERSONAL','BUSINESS') NULL     DEFAULT 'PERSONAL' COMMENT '회원 구분', -- 회원 구분
	is_subscribed TINYINT(1)                  NULL     DEFAULT 0 COMMENT '구독 여부', -- 구독 여부
	created_at    DATETIME                    NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '가입일' -- 가입일
)
COMMENT '사용자';

-- 사용자
ALTER TABLE member
	ADD CONSTRAINT PK_member -- 사용자 기본키
	PRIMARY KEY (
	member_id -- 사용자 고유번호
	);

-- 사용자 유니크 인덱스
CREATE UNIQUE INDEX uk_member_email
	ON member ( -- 사용자
		email ASC -- 이메일
	);

ALTER TABLE member
	MODIFY COLUMN member_id BIGINT NOT NULL AUTO_INCREMENT COMMENT '사용자 고유번호';
	
	
	
-- ==========================================
-- (1-1) 법인 프로필 (business_profile)
-- ==========================================
CREATE TABLE business_profile (
    member_id INT PRIMARY KEY,
    company_name VARCHAR(100) NOT NULL,
    business_reg_no VARCHAR(20) NOT NULL,
    representative_name VARCHAR(50) NOT NULL,
    FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE
);


-- ==========================================
-- (1-2) 주소록 (address)
-- ==========================================
CREATE TABLE address (
    id INT AUTO_INCREMENT PRIMARY KEY,
    member_id INT NOT NULL,
    address_name VARCHAR(50) NOT NULL,       -- 예: 집, 회사
    recipient_name VARCHAR(50) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    zip_code VARCHAR(10) NOT NULL,
    base_address VARCHAR(255) NOT NULL,
    detail_address VARCHAR(255) NOT NULL,
    is_default TINYINT(1) DEFAULT 0,         -- 1: 기본배송지, 0: 일반
    FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE
);

-- ==========================================
-- (2) 상품 (product) ========================
-- ==========================================

-- 상품
CREATE TABLE product (
	product_id     BIGINT       NOT NULL COMMENT '상품 고유번호', -- 상품 고유번호
	category_id    BIGINT       NULL     COMMENT '카테고리 고유번호', -- 카테고리 고유번호
	name           VARCHAR(100) NOT NULL COMMENT '상품명', -- 상품명
	brand          VARCHAR(50)  NOT NULL COMMENT '브랜드', -- 브랜드
	model_name     VARCHAR(100) NOT NULL COMMENT '모델명', -- 모델명
	base_price     INT          NOT NULL DEFAULT 0 COMMENT '출고가', -- 출고가
	stock_quantity INT          NOT NULL DEFAULT 0 COMMENT '재고 수량', -- 재고 수량
	description    TEXT         NULL     COMMENT '기기의 상세 스펙이나 란텔 유의사항' -- 상품 설명
)
COMMENT '상품';

-- 상품
ALTER TABLE product
	ADD CONSTRAINT PK_product -- 상품 기본키
	PRIMARY KEY (
	product_id -- 상품 고유번호
	);

ALTER TABLE product
	MODIFY COLUMN product_id BIGINT NOT NULL AUTO_INCREMENT COMMENT '상품 고유번호';
	
-- ==========================================
-- (2-1) 카테고리 (category)
-- ==========================================
CREATE TABLE category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    parent_id INT NULL,                      -- 계층형 카테고리 고려 (선택 사항)
    FOREIGN KEY (parent_id) REFERENCES category(id) ON DELETE SET NULL
);

-- ==========================================
-- (2-2) 상품 상세 사양 (product_spec)
-- ==========================================
CREATE TABLE product_spec (
    product_id INT NOT NULL,
    spec_key VARCHAR(50) NOT NULL,           -- 예: 'CPU', 'GPU', 'RAM'
    spec_value VARCHAR(255) NOT NULL,        -- 예: 'M3 Max', 'RTX 4090', '32GB'
    PRIMARY KEY (product_id, spec_key),      -- 복합키 구성
    FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE
);
	

-- ==========================================
-- (2-3) 렌탈가 관리 (rental_prices)
-- ==========================================
CREATE TABLE rental_prices (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    duration INT NOT NULL,                   -- 예: 36, 60 (개월 수)
    monthly_fee INT NOT NULL,                -- 월 렌탈료
    is_b2b_only TINYINT(1) DEFAULT 0,        -- 1: B2B 전용 요금제, 0: 공용
    FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE
);


-- ==========================================
-- (3) 주문 (orders) =========================
-- ==========================================

-- 주문
CREATE TABLE orders (
	order_id       BIGINT                            NOT NULL COMMENT '주문 고유번호', -- 주문 고유번호
	member_id      BIGINT                            NOT NULL COMMENT '회원 고유번호', -- 회원 고유번호
	total_amount   INT                               NOT NULL DEFAULT 0 COMMENT '총 결제 금액', -- 총 결제 금액
	order_status   ENUM('PENDING','PAID','CANCELED') NULL     DEFAULT 'PENDING' COMMENT '주문 상태', -- 주문 상태
	payment_method VARCHAR(50)                       NOT NULL COMMENT '결제 수단', -- 결제 수단
	billing_key    VARCHAR(255)                      NULL     COMMENT '빌링 키', -- 빌링 키
	created_at     DATETIME                          NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '주문 일시' -- 주문 일시
)
COMMENT '주문';

-- 주문
ALTER TABLE orders
	ADD CONSTRAINT PK_orders -- 주문 기본키
	PRIMARY KEY (
	order_id -- 주문 고유번호
	);

ALTER TABLE orders
	MODIFY COLUMN order_id BIGINT NOT NULL AUTO_INCREMENT COMMENT '주문 고유번호';
	
	
-- ==========================================
-- (3-1) 결제 내역 ()
-- ==========================================
	
	
	

-- 계약
CREATE TABLE contract (
	contract_id     BIGINT                                 NOT NULL COMMENT '계약 고유번호', -- 계약 고유번호
	member_id       BIGINT                                 NULL     COMMENT '회원 고유번호', -- 회원 고유번호
	order_id        BIGINT                                 NULL     COMMENT '주문 고유번호', -- 주문 고유번호
	product_id      BIGINT                                 NULL     COMMENT '상품 고유번호', -- 상품 고유번호
	contract_type   ENUM('RENTAL','SUBSCRIPTION')          NOT NULL COMMENT '계약 유형', -- 계약 유형
	contract_status ENUM('USING','RETURNING','TERMINATED') NULL     DEFAULT 'USING' COMMENT '계약 상태', -- 계약 상태
	start_date      DATE                                   NOT NULL COMMENT '대여 시작일', -- 대여 시작일
	end_date        DATE                                   NULL     COMMENT '대여 종료일' -- 대여 종료일
)
COMMENT '계약';

-- 계약
ALTER TABLE contract
	ADD CONSTRAINT PK_contract -- 계약 기본키
	PRIMARY KEY (
	contract_id -- 계약 고유번호
	);

ALTER TABLE contract
	MODIFY COLUMN contract_id BIGINT NOT NULL AUTO_INCREMENT COMMENT '계약 고유번호';

-- 주문
ALTER TABLE orders
	ADD CONSTRAINT FK_member_TO_orders -- 사용자 -> 주문
	FOREIGN KEY (
	member_id -- 회원 고유번호
	)
	REFERENCES member ( -- 사용자
	member_id -- 사용자 고유번호
	);

-- 계약
ALTER TABLE contract
	ADD CONSTRAINT FK_member_TO_contract -- 사용자 -> 계약
	FOREIGN KEY (
	member_id -- 회원 고유번호
	)
	REFERENCES member ( -- 사용자
	member_id -- 사용자 고유번호
	);

-- 계약
ALTER TABLE contract
	ADD CONSTRAINT FK_orders_TO_contract -- 주문 -> 계약
	FOREIGN KEY (
	order_id -- 주문 고유번호
	)
	REFERENCES orders ( -- 주문
	order_id -- 주문 고유번호
	);

-- 계약
ALTER TABLE contract
	ADD CONSTRAINT FK_product_TO_contract -- 상품 -> 계약
	FOREIGN KEY (
	product_id -- 상품 고유번호
	)
	REFERENCES product ( -- 상품
	product_id -- 상품 고유번호
	);