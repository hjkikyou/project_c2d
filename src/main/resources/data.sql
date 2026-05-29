-- ==========================================
-- 1. 사용자 (member) 더미 데이터
-- ==========================================
INSERT INTO member (email, password, name, phone, user_type, is_subscribed, created_at) VALUES 
('user1@example.com', '{bcrypt}dummy_hash_1', '김철수', '010-1234-5678', 'PERSONAL', 1, NOW()),
('user2@example.com', '{bcrypt}dummy_hash_2', '이영희', '010-9876-5432', 'PERSONAL', 0, NOW()),
('business@example.com', '{bcrypt}dummy_hash_3', '박대표', '010-5555-7777', 'BUSINESS', 1, NOW()),
('user3@example.com', '{bcrypt}dummy_hash_4', '최민수', '010-2222-3333', 'PERSONAL', 1, NOW()),
('user4@example.com', '{bcrypt}dummy_hash_5', '정수진', '010-4444-5555', 'PERSONAL', 0, NOW()),
('corp1@example.com', '{bcrypt}dummy_hash_6', '강만석', '010-8888-9999', 'BUSINESS', 1, NOW()),
('user5@example.com', '{bcrypt}dummy_hash_7', '한지민', '010-7777-8888', 'PERSONAL', 1, NOW()),
('user6@example.com', '{bcrypt}dummy_hash_8', '오재성', '010-3333-4444', 'PERSONAL', 0, NOW()),
('corp2@example.com', '{bcrypt}dummy_hash_9', '윤지호', '010-6666-1111', 'BUSINESS', 0, NOW()),
('user7@example.com', '{bcrypt}dummy_hash_10', '임서현', '010-1111-2222', 'PERSONAL', 1, NOW());

-- ==========================================
-- 2. 상품 (product) 더미 데이터
-- ==========================================
-- category_id는 임의로 1(노트북), 2(스마트폰), 3(태블릿)으로 가정했습니다.
INSERT INTO product (category_id, name, brand, model_name, base_price, stock_quantity, description) VALUES 
(1, '맥북 프로 16인치', 'Apple', 'MacBook Pro 16 M3 Max', 3500000, 10, '전문가를 위한 최고 성능의 노트북입니다.'),
(2, '갤럭시 S24 울트라', 'Samsung', 'SM-S928N', 1690000, 50, 'AI 기능이 탑재된 최신 플래그십 스마트폰.'),
(3, '아이패드 에어 5세대', 'Apple', 'iPad Air 5th Gen', 890000, 20, '가볍고 강력한 M1 칩 탑재 태블릿.'),
(4, '아이폰 15 프로', 'Apple', 'iPhone 15 Pro', 1550000, 30, '티타늄 소재와 A17 Pro 칩을 탑재한 프리미엄 스마트폰.'),
(5, '갤럭시 워치6', 'Samsung', 'SM-R930', 329000, 45, '스마트한 건강 관리를 위한 데일리 웨어러블 워치.'),
(6, '소니 노이즈캔슬링 헤드폰', 'Sony', 'WH-1000XM5', 499000, 15, '업계 최고 수준의 소음 차단 성능을 자랑하는 헤드폰.'),
(7, 'LG 올레드 TV 65인치', 'LG', 'OLED654K', 2400000, 5, '압도적인 화질과 얇은 디자인의 4K 올레드 TV.'),
(8, '로지텍 마스터 3S', 'Logitech', 'MX Master 3S', 139000, 60, '개발자와 디자이너를 위한 무소음 최고급 무선 마우스.'),
(9, '다이슨 에어랩 멀티 스타일러', 'Dyson', 'Airwrap Complete', 699000, 12, '과도한 열 손상 없이 스타일링이 가능한 헤어 스타일러.'),
(10, '닌텐도 스위치 OLED', 'Nintendo', 'HEG-S-KAAAA', 415000, 25, '선명한 OLED 디스플레이로 즐기는 콘솔 게임기.');

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