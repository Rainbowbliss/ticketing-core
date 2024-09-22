INSERT INTO public.users(id, email, name) VALUES (1000, 'Teszt Aladár', 'teszt.aladar@otpmobil.com');
INSERT INTO public.users(id, email, name) VALUES (2000, 'Teszt Benedek', 'teszt.benedek@otpmobil.com');
INSERT INTO public.users(id, email, name) VALUES (3000, 'Teszt Cecília', 'teszt.cecilia@otpmobil.com');

INSERT INTO public.user_device(user_id, device_hash)VALUES (1000, 'F67C2BCBFCFA30FCCB36F72DCA22A817');
INSERT INTO public.user_device(user_id, device_hash)VALUES (1000, '0F1674BD19D3BBDD4C39E14734FFB876');
INSERT INTO public.user_device(user_id, device_hash)VALUES (1000, '3AE5E9658FBD7D4048BD40820B7D227D');
INSERT INTO public.user_device(user_id, device_hash)VALUES (2000, 'FADDFEA562F3C914DCC81956682DB0FC');
INSERT INTO public.user_device(user_id, device_hash)VALUES (3000, 'E68560872BDB2DF2FFE7ADC091755378');

INSERT INTO public.user_token(user_id, token) VALUES (1000, 'dGVzenQuYWxhZGFyQG90cG1vYmlsLmNvbSYxMDAwJkY2N0MyQkNCRkNGQTMwRkNDQjM2RjcyRENBMjJBODE3');
INSERT INTO public.user_token(user_id, token) VALUES (1000, 'dGVzenQuYWxhZGFyQG90cG1vYmlsLmNvbSYxMDAwJjBGMTY3NEJEMTlEM0JCREQ0QzM5RTE0NzM0RkZCODc2');
INSERT INTO public.user_token(user_id, token) VALUES (1000, 'dGVzenQuYWxhZGFyQG90cG1vYmlsLmNvbSYxMDAwJjNBRTVFOTY1OEZCRDdENDA0OEJENDA4MjBCN0QyMjdE');
INSERT INTO public.user_token(user_id, token) VALUES (2000, 'dGVzenQuYmVuZWRla0BvdHBtb2JpbC5jb20mMjAwMCZGQURERkVBNTYyRjNDOTE0RENDODE5NTY2ODJEQjBGQw==');
INSERT INTO public.user_token(user_id, token) VALUES (3000, 'dGVzenQuY2VjaWxpYUBvdHBtb2JpbC5jb20mMzAwMCZFNjg1NjA4NzJCREIyREYyRkZFN0FEQzA5MTc1NTM3OA==');

INSERT INTO public.user_bank_card(amount, user_id, card_id, card_number, currency, cvc, name) VALUES (1000, 1000, 'C0001', '5299706965433676', 'HUF', 123, 'Teszt Aladár');
INSERT INTO public.user_bank_card(amount, user_id, card_id, card_number, currency, cvc, name) VALUES (2000, 2000, 'C0002', '5390508354245119', 'HUF', 456, 'Teszt Benedek');
INSERT INTO public.user_bank_card(amount, user_id, card_id, card_number, currency, cvc, name) VALUES (3000, 3000, 'C0003', '4929088924014470', 'HUF', 789, 'Teszt Cecília');