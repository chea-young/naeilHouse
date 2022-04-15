INSERT INTO consumer (consumer_id, id, name, pwd, point) VALUES (1, '1234', '홍길동', '1234', 123);
INSERT INTO post (id, consumer_id) VALUES (1, 1);
INSERT INTO Likes (id, consumer_id, post_id) VALUES (1, 1, 1);

INSERT INTO Seller (seller_id, name, s_Id, store_Name, IS_APPROVED ) values (1, '판매자1', '1234', '내일의 집', TRUE);
INSERT INTO Seller (seller_id, name, s_Id, store_Name, IS_APPROVED ) values (2, '판매자2', '155234', '오늘의 집', FALSE);

INSERT INTO ORDERS  (ORDER_ID, ORDER_DATE , CONSUMER_ID, ORDER_STATUS) VALUES (1, '20221010', 1, 1);
INSERT INTO ORDERS  (ORDER_ID, ORDER_DATE , CONSUMER_ID, ORDER_STATUS) VALUES (2, '20221011', 1, 0);
INSERT INTO ORDERS  (ORDER_ID, ORDER_DATE , CONSUMER_ID, ORDER_STATUS) VALUES (3, '20221012', 1, 3);
INSERT INTO ITEM  (ITEM_ID , CATEGORY , NAME , PRICE , SELLER_ID  ) VALUES (1, '가방', '가방', 1000, 1);
INSERT INTO ITEM  (ITEM_ID , CATEGORY , NAME , PRICE , SELLER_ID  ) VALUES (2, '옷', '옷', 4000, 1);
INSERT INTO ORDER_ITEM  (ID,COUNT ,ORDER_PRICE ,ITEM_ID ,ORDER_ID  ) VALUES (1, 1, 1000, 1, 1);
INSERT INTO ORDER_ITEM  (ID,COUNT ,ORDER_PRICE ,ITEM_ID ,ORDER_ID  ) VALUES (2, 1, 1000, 1, 1);
INSERT INTO ORDER_ITEM  (ID,COUNT ,ORDER_PRICE ,ITEM_ID ,ORDER_ID  ) VALUES (2, 1, 1000, 2, 2);
INSERT INTO ORDER_ITEM  (ID,COUNT ,ORDER_PRICE ,ITEM_ID ,ORDER_ID  ) VALUES (2, 1, 1000, 2, 3);