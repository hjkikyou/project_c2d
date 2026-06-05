-- ==========================================
-- 더미 데이터 삽입 (PC 하드웨어 렌탈 서비스 기준)
-- ==========================================
SET FOREIGN_KEY_CHECKS = 0;

-- 1. 회원 (B2C 개인회원 7명, B2B 기업회원 3명)
INSERT INTO member (member_id, email, password, name, phone, user_type, is_subscribed) VALUES
(1, 'user1@gmail.com', 'hashed_pwd_1', '김지훈', '010-1111-1111', 'PERSONAL', 1),
(2, 'user2@gmail.com', 'hashed_pwd_2', '이서연', '010-2222-2222', 'PERSONAL', 0),
(3, 'user3@gmail.com', 'hashed_pwd_3', '박도현', '010-3333-3333', 'PERSONAL', 1),
(4, 'user4@gmail.com', 'hashed_pwd_4', '최유진', '010-4444-4444', 'PERSONAL', 0),
(5, 'user5@gmail.com', 'hashed_pwd_5', '정민우', '010-5555-5555', 'PERSONAL', 0),
(6, 'user6@gmail.com', 'hashed_pwd_6', '강수아', '010-6666-6666', 'PERSONAL', 1),
(7, 'user7@gmail.com', 'hashed_pwd_7', '조현우', '010-7777-7777', 'PERSONAL', 0),
(8, 'b2b1@company.com', 'hashed_pwd_8', '윤태양', '010-8888-8888', 'BUSINESS', 1),
(9, 'b2b2@startup.com', 'hashed_pwd_9', '임지아', '010-9999-9999', 'BUSINESS', 0),
(10, 'b2b3@enterprise.com', 'hashed_pwd_10', '한승민', '010-0000-0000', 'BUSINESS', 1);
-- 2. 사업자 프로필 (기업 회원 3명)
INSERT INTO business_profile (member_id, company_name, business_reg_no, representative_name) VALUES
(8, '(주)테크솔루션', '123-45-67890', '윤태양'),
(9, '스타트업랩', '234-56-78901', '임지아'),
(10, '엔터프라이즈IT', '345-67-89012', '한승민');

-- 3. 배송지 (각 회원당 1개씩)
INSERT INTO address (address_id, member_id, address_name, recipient_name, phone, zip_code, base_address, detail_address, is_default) VALUES
(1, 1, '집', '김지훈', '010-1111-1111', '01234', '서울시 강남구 테헤란로', '101동 101호', 1),
(2, 2, '집', '이서연', '010-2222-2222', '02345', '서울시 서초구 서초대로', '202동 202호', 1),
(3, 3, '회사', '박도현', '010-3333-3333', '03456', '경기도 성남시 분당구 판교역로', '3층', 1),
(4, 4, '집', '최유진', '010-4444-4444', '04567', '서울시 송파구 올림픽로', '404호', 1),
(5, 5, '집', '정민우', '010-5555-5555', '05678', '인천시 연수구 송도과학로', '505호', 1),
(6, 6, '집', '강수아', '010-6666-6666', '06789', '부산시 해운대구 센텀중앙로', '606호', 1),
(7, 7, '회사', '조현우', '010-7777-7777', '07890', '대구시 수성구 달구벌대로', '7층', 1),
(8, 8, '본사', '윤태양', '010-8888-8888', '08901', '서울시 중구 세종대로', '테크솔루션 8층', 1),
(9, 9, '공유오피스', '임지아', '010-9999-9999', '09012', '서울시 강남구 역삼로', '위워크 9층', 1),
(10, 10, '물류센터', '한승민', '010-0000-0000', '10123', '경기도 용인시 처인구', '물류동 10번 게이트', 1);

-- 4. 카테고리 (계층형)
INSERT INTO category (category_id, name, parent_id) VALUES
(1, '노트북', NULL),
(2, '데스크탑', NULL),
(3, '모니터', NULL),
(4, 'MacBook', 1),
(5, '게이밍 PC', 2);

-- 5. 상품 (PC 하드웨어 10종)
INSERT INTO product (product_id, category_id, name, brand, model_name, base_price, stock_quantity, description) VALUES
(1, 4, 'MacBook Pro 16 M3 Max', 'Apple', 'MBP16-M3M', 4500000, 15, '전문가용 최고사양 맥북'),
(2, 4, 'MacBook Air 15 M3', 'Apple', 'MBA15-M3', 2000000, 30, '가벼운 사무용 맥북'),
(3, 5, 'RTX 4090 딥러닝 워크스테이션', 'Custom', 'WS-4090', 5500000, 5, 'AI 개발 및 3D 렌더링용 PC'),
(4, 5, 'RTX 4070 게이밍 데스크탑', 'ASUS', 'ROG-4070', 2500000, 20, '하이엔드 게이밍 PC'),
(5, 3, '32인치 4K UHD 모니터', 'LG전자', '32UN880', 800000, 50, '디자인 작업용 4K 모니터'),
(6, 1, '갤럭시북4 프로 16인치', '삼성전자', 'NT960XGK', 2200000, 25, '윈도우 사무용 끝판왕'),
(7, 1, '씽크패드 X1 카본 11세대', 'Lenovo', 'X1-Carbon', 2100000, 15, '비즈니스 랩탑의 표준'),
(8, 2, '사무용 미니 PC', 'Intel', 'NUC-13', 700000, 100, '공간 절약형 사무용 PC'),
(9, 3, '27인치 QHD 게이밍 모니터', 'LG전자', '27GP850', 500000, 40, '165Hz 게이밍 모니터'),
(10, 4, 'Mac Studio M2 Ultra', 'Apple', 'MAC-STU', 6000000, 3, '스튜디오용 영상편집 데스크탑');

-- 6. 상품 상세 사양
INSERT INTO product_spec (product_id, spec_key, spec_value) VALUES
(1, 'CPU', 'M3 Max 16코어'), (1, 'RAM', '64GB'), (1, 'SSD', '2TB'),
(3, 'GPU', 'RTX 4090 24GB'), (3, 'RAM', '128GB'), (3, 'POWER', '1200W'),
(5, '해상도', '3840x2160 (4K)'), (5, '패널', 'IPS'),
(6, 'CPU', 'Intel Core Ultra 7'), (6, 'RAM', '32GB');

-- 7. 렌탈가 관리 (B2C/B2B 가격 분리)
INSERT INTO rental_prices (rental_price_id, product_id, duration, monthly_fee, is_b2b_only) VALUES
(1, 1, 36, 130000, 0), -- 맥북 프로 36개월 B2C
(2, 1, 60, 90000, 0),
(3, 3, 24, 250000, 1), -- RTX 4090 24개월 B2B 전용
(4, 5, 36, 25000, 0),
(5, 6, 36, 65000, 0),
(6, 8, 36, 20000, 1), -- 사무용 미니PC B2B 전용 대량렌탈가
(7, 8, 12, 30000, 1),
(8, 10, 36, 180000, 0),
(9, 2, 36, 60000, 0),
(10, 4, 36, 75000, 0);

-- 1. 주문 테이블 (영수증 머리말)
-- 상태를 타임리프 화면과 맞춰서 '결제완료', '주문취소'로 변경했습니다.
INSERT INTO orders (order_id, member_id, total_amount, order_status, payment_method, billing_key) VALUES
(1, 1, 130000, '결제완료', 'CREDIT_CARD', 'bk_card_001'),
(2, 2, 60000, '결제완료', 'CREDIT_CARD', 'bk_card_002'),
(3, 3, 75000, '결제완료', 'NAVER_PAY', 'bk_npay_003'),
(4, 4, 180000, '결제완료', 'KAKAO_PAY', 'bk_kpay_004'),
(5, 5, 25000, '결제완료', 'CREDIT_CARD', 'bk_card_005'),
(6, 8, 250000, '결제완료', 'BANK_TRANSFER', NULL), 
(7, 9, 200000, '결제완료', 'BANK_TRANSFER', NULL),
(8, 10, 30000, '결제완료', 'CREDIT_CARD', 'bk_card_008'),
(9, 6, 65000, '결제완료', 'TOSS_PAY', 'bk_toss_009'),
(10, 7, 25000, '주문취소', 'CREDIT_CARD', NULL);


-- 2. 주문 상세 테이블 (영수증 알맹이 - 우리가 추가해야 할 진짜 알맹이!)
-- product_id는 기존 상품 테이블에 1, 2, 3번 상품이 있다고 가정한 더미 데이터입니다.
INSERT INTO order_item (order_id, product_id, order_price, count) VALUES
(1, 1, 130000, 1), -- 1번 주문: 1번 상품 1개 구매
(2, 2, 30000, 2),  -- 2번 주문: 2번 상품 2개 구매 (총액 6만)
(3, 3, 75000, 1),  -- 3번 주문: 3번 상품 1개 구매
(4, 1, 90000, 2),  -- 4번 주문: 1번 상품 2개 구매 (총액 18만)
(5, 2, 25000, 1),  -- 5번 주문: 2번 상품 1개 구매
(6, 4, 250000, 1), -- 6번 주문: 4번 상품 1개 구매
(7, 5, 100000, 2), -- 7번 주문: 5번 상품 2개 구매
(8, 1, 30000, 1),  -- 8번 주문: 1번 상품 1개 구매
(9, 3, 65000, 1),  -- 9번 주문: 3번 상품 1개 구매
(10, 2, 25000, 1); -- 10번 주문: 2번 상품 1개 구매 (취소됨)

-- 보너스: 다중 장바구니 결제 테스트용 (1번 주문에 상품 하나 더 추가!)
INSERT INTO order_item (order_id, product_id, order_price, count) VALUES
(1, 2, 0, 1); -- 1번 회원은 상품 2개를 같이 샀다는 것을 보여주기 위한 테스트용

-- 9. 계약 (렌탈 및 구독)
INSERT INTO contract (contract_id, member_id, order_id, product_id, monthly_fee, duration, contract_type, contract_status, start_date, end_date) VALUES
(1, 1, 1, 1, 130000, 36, 'RENTAL', 'USING', '2024-01-01', '2027-01-01'),
(2, 2, 2, 2, 60000, 36, 'RENTAL', 'USING', '2024-02-15', '2027-02-15'),
(3, 3, 3, 4, 75000, 36, 'RENTAL', 'USING', '2024-03-10', '2027-03-10'),
(4, 4, 4, 10, 180000, 36, 'RENTAL', 'USING', '2024-04-05', '2027-04-05'),
(5, 5, 5, 5, 25000, 36, 'RENTAL', 'USING', '2024-04-20', '2027-04-20'),
(6, 8, 6, 3, 250000, 24, 'RENTAL', 'USING', '2024-05-01', '2026-05-01'),
(7, 9, 7, 8, 200000, 36, 'RENTAL', 'USING', '2024-05-10', '2027-05-10'), -- 수량 10대 계약 가정(주문금액 20만)
(8, 10, 8, 8, 30000, 12, 'RENTAL', 'USING', '2024-06-01', '2025-06-01'),
(9, 6, 9, 6, 65000, 36, 'SUBSCRIPTION', 'TERMINATED', '2023-01-01', '2024-01-01'), -- 중도해지
(10, 1, 1, 6, 25000, 36, 'RENTAL', 'USING', '2024-01-01', '2027-01-01'); -- 회원1번이 모니터도 같이 빌림

-- 10. 결제 이력 (스케줄러에 의해 매달 결제되는 내역)
INSERT INTO payment_history (payment_history_id, contract_id, amount, status, fail_reason, billing_key) VALUES
(1, 1, 130000, 'SUCCESS', NULL, 'bk_card_001'),
(2, 2, 60000, 'SUCCESS', NULL, 'bk_card_002'),
(3, 3, 75000, 'SUCCESS', NULL, 'bk_npay_003'),
(4, 4, 180000, 'FAILED', '잔액 부족', 'bk_kpay_004'),
(5, 5, 25000, 'SUCCESS', NULL, 'bk_card_005'),
(6, 6, 250000, 'SUCCESS', NULL, NULL),
(7, 7, 200000, 'SUCCESS', NULL, NULL),
(8, 8, 30000, 'SUCCESS', NULL, 'bk_card_008'),
(9, 9, 65000, 'SUCCESS', NULL, 'bk_toss_009'),
(10, 1, 130000, 'SUCCESS', NULL, 'bk_card_001'); -- 2회차 결제 성공

-- 11. 배송 내역
INSERT INTO delivery (delivery_id, order_id, tracking_number, carrier, status, dispatched_at, delivered_at) VALUES
(1, 1, 'CJ1234567890', 'CJ대한통운', 'DELIVERED', '2024-01-02 10:00:00', '2024-01-03 15:00:00'),
(2, 2, 'CJ1234567891', 'CJ대한통운', 'DELIVERED', '2024-02-16 10:00:00', '2024-02-17 14:00:00'),
(3, 3, 'HN0987654321', '한진택배', 'DELIVERED', '2024-03-11 11:00:00', '2024-03-12 12:00:00'),
(4, 4, 'LT1122334455', '롯데택배', 'SHIPPING', '2024-04-06 09:00:00', NULL),
(5, 5, 'CJ1234567892', 'CJ대한통운', 'PREPARING', NULL, NULL),
(6, 6, 'DR00001', '자체직배송', 'DELIVERED', '2024-05-02 09:00:00', '2024-05-02 11:00:00'), -- B2B 직배송
(7, 7, 'DR00002', '자체직배송', 'DELIVERED', '2024-05-11 09:00:00', '2024-05-11 13:00:00'),
(8, 8, 'CJ1234567893', 'CJ대한통운', 'SHIPPING', '2024-06-02 10:00:00', NULL),
(9, 9, 'CJ1234567894', 'CJ대한통운', 'RETURN_SHIPPING', '2024-01-05 10:00:00', NULL), -- 반납 중
(10, 1, 'CJ1234567895', 'CJ대한통운', 'DELIVERED', '2024-01-02 10:00:00', '2024-01-03 15:00:00'); -- 모니터 배송

-- 12. 리뷰
INSERT INTO review (review_id, member_id, product_id, contract_id, rating, content, image_url) VALUES
(1, 1, 1, 1, 5, '성능 최고입니다. 렌탈로 초기비용 아껴서 좋아요.', 'img1.jpg'),
(2, 2, 2, 2, 5, '디자인 예쁘고 가벼워서 휴대하기 좋습니다.', 'img2.jpg'),
(3, 3, 4, 3, 4, '게임 잘 돌아가는데 쿨러 소음이 약간 있네요.', NULL),
(4, 6, 6, 9, 3, '사용하다가 일이 생겨서 중도해지 했습니다. 기기는 좋아요.', NULL),
(5, 8, 3, 6, 5, '딥러닝용으로 여러 대 렌탈했습니다. 법인 비용처리 편해요.', NULL),
(6, 1, 5, 10, 5, '맥북이랑 같이 쓰려고 모니터도 렌탈했어요. 화질 미쳤음', 'img3.jpg'),
(7, 2, 2, 2, 4, '배송이 빨라서 좋았습니다.', NULL),
(8, 3, 4, 3, 5, 'RTX4070 확실히 프레임 잘 뽑아줍니다.', 'img4.jpg'),
(9, 5, 5, 5, 5, '디자인 작업용으로 가성비 짱짱맨', NULL),
(10, 10, 8, 8, 4, '직원들 사무용으로 작고 딱 맞습니다.', 'img5.jpg');

-- 13. 장바구니
INSERT INTO cart (cart_id, member_id, product_id, rental_type, duration, quantity) VALUES
(1, 1, 3, 'RENTAL', 36, 1),
(2, 1, 5, 'RENTAL', 36, 2),
(3, 2, 1, 'SUBSCRIPTION', NULL, 1),
(4, 3, 9, 'RENTAL', 24, 1),
(5, 4, 6, 'RENTAL', 60, 1),
(6, 8, 8, 'RENTAL', 12, 10), -- 기업회원 대량 담기
(7, 9, 3, 'RENTAL', 24, 2),
(8, 10, 5, 'RENTAL', 36, 5),
(9, 5, 2, 'SUBSCRIPTION', NULL, 1),
(10, 6, 4, 'RENTAL', 36, 1);

-- 14. 찜하기
INSERT INTO wishlist (wishlist_id, member_id, product_id) VALUES
(1, 1, 10), (2, 1, 3), (3, 2, 1), (4, 3, 4), (5, 3, 9),
(6, 4, 1), (7, 5, 6), (8, 8, 3), (9, 9, 8), (10, 10, 10);

-- 15. 구독 플랜 (멤버십)
INSERT INTO subscription_plan (plan_id, plan_name, monthly_fee, benefits_desc) VALUES
(1, '베이직', 9900, '전 상품 5% 할인, 기본 배송 무료'),
(2, '프로', 19900, '전 상품 10% 할인, 무료 반품, 프리미엄 AS'),
(3, '마스터', 29900, '전 상품 15% 할인, 최우선 배송, VIP 전담 매니저');

-- 16. 구독 상태
INSERT INTO subscription_status (subscription_status_id, member_id, plan_id, status, start_date, end_date, next_billing_date) VALUES
(1, 1, 1, 'ACTIVE', '2024-01-01', NULL, '2024-02-01'),
(2, 3, 1, 'ACTIVE', '2024-03-01', NULL, '2024-04-01'),
(3, 6, 2, 'ACTIVE', '2024-04-01', NULL, '2024-05-01'),
(4, 8, 3, 'ACTIVE', '2023-10-01', NULL, '2024-06-01'),
(5, 10, 2, 'ACTIVE', '2024-05-01', NULL, '2024-06-01'),
(6, 2, 1, 'CANCELED', '2023-01-01', '2023-12-01', '2023-12-01'),
(7, 4, 1, 'CANCELED', '2023-05-01', '2023-08-01', '2023-08-01'),
(8, 5, 1, 'ACTIVE', '2024-06-01', NULL, '2024-07-01'),
(9, 7, 3, 'ACTIVE', '2024-06-15', NULL, '2024-07-15'),
(10, 9, 2, 'ACTIVE', '2024-06-20', NULL, '2024-07-20');

-- 17. 대량 견적 (B2B 전용)
INSERT INTO quote (quote_id, member_id, status, total_quantity, proposed_amount, admin_comment) VALUES
(1, 8, 'COMPLETED', 20, 14000000, '할인율 15% 적용 승인되었습니다.'),
(2, 9, 'APPROVED', 50, 35000000, '요청하신 사양으로 세팅 가능합니다.'),
(3, 10, 'REQUEST', 5, 25000000, NULL),
(4, 8, 'REQUEST', 10, 7000000, NULL),
(5, 9, 'COMPLETED', 30, 21000000, '최종 견적서 발송 완료'),
(6, 10, 'REQUEST', 2, 11000000, NULL),
(7, 8, 'APPROVED', 15, 10500000, '승인 대기 중'),
(8, 9, 'REQUEST', 100, 70000000, '물량 확보 확인 중'),
(9, 10, 'COMPLETED', 10, 7000000, '납품 완료'),
(10, 8, 'REQUEST', 3, 6000000, NULL);

-- 18. 세금계산서 (B2B 전용)
INSERT INTO tax_invoice (tax_invoice_id, order_id, status, invoice_url) VALUES
(1, 6, 'ISSUED', 'https://invoice.link/1234'),
(2, 7, 'ISSUED', 'https://invoice.link/5678'),
(3, 8, 'APPLIED', NULL),
(4, 6, 'ISSUED', 'https://invoice.link/9012'),
(5, 7, 'ISSUED', 'https://invoice.link/3456'),
(6, 8, 'APPLIED', NULL),
(7, 6, 'ISSUED', 'https://invoice.link/7890'),
(8, 7, 'APPLIED', NULL),
(9, 8, 'ISSUED', 'https://invoice.link/1122'),
(10, 6, 'APPLIED', NULL);

-- 19. 1:1 문의
INSERT INTO inquiry (inquiry_id, member_id, title, content, answer_content, status) VALUES
(1, 1, '결제 카드 변경하고 싶습니다.', '어떻게 하나요?', '마이페이지 > 결제수단 관리에서 변경 가능합니다.', 'ANSWERED'),
(2, 2, '배송 언제 되나요?', '급해서요.', NULL, 'PENDING'),
(3, 3, '램 업그레이드 문의', '추가금 내고 64GB로 변경되나요?', '렌탈 상품은 임의 개조가 불가능합니다.', 'ANSWERED'),
(4, 8, '대량 렌탈 세금계산서 발행 시점 문의', '언제 되나요?', '매월 10일에 일괄 발행됩니다.', 'ANSWERED'),
(5, 9, '중도 해지 위약금 문의', '얼마인가요?', '잔여 렌탈료의 30%입니다.', 'ANSWERED'),
(6, 4, '상품 흠집 관련', '받았는데 기스가 있어요', '사진 첨부해주시면 교환 처리 돕겠습니다.', 'ANSWERED'),
(7, 5, '반납 방법', '택배로 보내면 되나요?', NULL, 'PENDING'),
(8, 10, '견적서 요청', '서면 견적서 부탁드립니다.', '이메일로 발송해 드렸습니다.', 'ANSWERED'),
(9, 6, '할인 쿠폰 적용 문의', '안 먹히네요.', NULL, 'PENDING'),
(10, 7, '회원 탈퇴 방법', '탈퇴하고 싶습니다.', '계약 진행 중인 건이 있어 탈퇴가 제한됩니다.', 'ANSWERED');

-- 20. AS 접수
INSERT INTO as_request (as_request_id, contract_id, symptom, visit_date, status) VALUES
(1, 1, '화면이 갑자기 안 나옵니다.', '2024-05-15', 'COMPLETED'),
(2, 3, '팬 소음이 너무 심해요.', '2024-05-20', 'IN_PROGRESS'),
(3, 4, '부팅이 안 됩니다.', '2024-05-25', 'RECEIVED'),
(4, 6, 'GPU 렌더링 중 블루스크린 발생', '2024-05-21', 'COMPLETED'),
(5, 7, '키보드 하나가 안 눌림', '2024-05-22', 'IN_PROGRESS'),
(6, 2, '발열이 너무 심해요', '2024-06-01', 'RECEIVED'),
(7, 8, '모니터에 데드픽셀이 있어요', '2024-05-23', 'COMPLETED'),
(8, 10, '전원이 안 켜짐', '2024-05-28', 'RECEIVED'),
(9, 5, '와이파이 연결 끊김', '2024-05-29', 'RECEIVED'),
(10, 1, '트랙패드 클릭 안됨', '2024-06-05', 'RECEIVED');

SET FOREIGN_KEY_CHECKS = 1;