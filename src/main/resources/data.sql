-- ==========================================
-- 1. 사용자 (member) 더미 데이터
-- ==========================================
INSERT INTO member (email, password, name, phone, user_type, is_subscribed, created_at) VALUES 
('user1@example.com', '{bcrypt}dummy_hash_1', '김철수', '010-1234-5678', 'PERSONAL', 1, NOW()),
('user2@example.com', '{bcrypt}dummy_hash_2', '이영희', '010-9876-5432', 'PERSONAL', 0, NOW()),
('business@example.com', '{bcrypt}dummy_hash_3', '박대표', '010-5555-7777', 'BUSINESS', 1, NOW());

-- ==========================================
-- 2. 상품 (product) 더미 데이터
-- ==========================================
-- category_id는 임의로 1(노트북), 2(스마트폰), 3(태블릿)으로 가정했습니다.
INSERT INTO product (category_id, name, brand, model_name, base_price, stock_quantity, description) VALUES 
(1, '맥북 프로 16인치', 'Apple', 'MacBook Pro 16 M3 Max', 3500000, 10, '전문가를 위한 최고 성능의 노트북입니다.'),
(2, '갤럭시 S24 울트라', 'Samsung', 'SM-S928N', 1690000, 50, 'AI 기능이 탑재된 최신 플래그십 스마트폰.'),
(3, '아이패드 에어 5세대', 'Apple', 'iPad Air 5th Gen', 890000, 20, '가볍고 강력한 M1 칩 탑재 태블릿.');

-- ==========================================
-- 3. 주문 (orders) 더미 데이터
-- (반드시 member 데이터가 먼저 존재해야 합니다)
-- ==========================================
INSERT INTO orders (member_id, total_amount, order_status, payment_method, billing_key, created_at) VALUES 
(1, 150000, 'PAID', 'CREDIT_CARD', 'bk_card_12345a', NOW()),       -- 철수의 결제 완료 주문
(2, 50000, 'PENDING', 'BANK_TRANSFER', NULL, NOW()),               -- 영희의 무통장 입금 대기 주문
(3, 300000, 'PAID', 'CREDIT_CARD', 'bk_card_98765b', NOW());       -- 박대표의 결제 완료 주문

-- ==========================================
-- 4. 계약 (contract) 더미 데이터
-- (반드시 member, product, orders 데이터가 모두 존재해야 합니다)
-- ==========================================
INSERT INTO contract (member_id, order_id, product_id, contract_type, contract_status, start_date, end_date) VALUES 
(1, 1, 1, 'RENTAL', 'USING', '2024-05-01', '2024-05-31'),          -- 철수: 맥북 1개월 단기 렌탈 중
(2, 2, 3, 'SUBSCRIPTION', 'TERMINATED', '2023-01-01', '2023-12-31'), -- 영희: 아이패드 1년 구독 후 종료됨 (과거 이력)
(3, 3, 2, 'RENTAL', 'USING', '2024-05-15', NULL);                  -- 박대표: 갤럭시 무기한 렌탈 중