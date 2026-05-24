-- 주문
ALTER TABLE orders
	DROP FOREIGN KEY FK_member_TO_orders; -- 사용자 -> 주문

-- 계약
ALTER TABLE contract
	DROP FOREIGN KEY FK_member_TO_contract; -- 사용자 -> 계약

-- 계약
ALTER TABLE contract
	DROP FOREIGN KEY FK_orders_TO_contract; -- 주문 -> 계약

-- 계약
ALTER TABLE contract
	DROP FOREIGN KEY FK_product_TO_contract; -- 상품 -> 계약

-- 사용자
DROP TABLE IF EXISTS member RESTRICT;

-- 상품
DROP TABLE IF EXISTS product RESTRICT;

-- 주문
DROP TABLE IF EXISTS orders RESTRICT;

-- 계약
DROP TABLE IF EXISTS contract RESTRICT;

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