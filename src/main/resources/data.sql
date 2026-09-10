-- Sample investor: eligible for retirement withdrawals (age > 65)
INSERT INTO investor (id, name, age) VALUES (1, 'Jane Dlamini', 70);

-- Sample investor: NOT eligible for retirement withdrawals (age <= 65)
INSERT INTO investor (id, name, age) VALUES (2, 'Sipho Nkosi', 40);

-- Products belonging to each investor
INSERT INTO product (id, type, balance, investor_id) VALUES (1, 'Retirement', 100000.00, 1);
INSERT INTO product (id, type, balance, investor_id) VALUES (2, 'Savings', 50000, 2);