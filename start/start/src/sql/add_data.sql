INSERT INTO UPLOAD_FILE (UPLOADFILE_ID , STORE_FILE_NAME , UPLOAD_FILE_NAME ) values (1, 'default_img.png', 'default_img.png');

INSERT INTO consumer (consumer_id, id, name, pwd, point) VALUES (1, '1234', '홍길동', '1234', 123);
INSERT INTO consumer (consumer_id, id, name, pwd, point) VALUES (2, '12345', '홍길동', '1234', 123);
INSERT INTO post (id, consumer_id, CONTENTS , POST_DATE, UPLOADFILE_ID) VALUES (1, 1, '게시글 내용1', '20221012', 1);
INSERT INTO post (id, consumer_id, CONTENTS , POST_DATE, UPLOADFILE_ID) VALUES (2, 1, '게시글 내용2', '20221010', 1);
INSERT INTO Likes (id, consumer_id, post_id) VALUES (1, 1, 1);

INSERT INTO Seller (seller_id, name, s_Id, pwd, store_Name, IS_APPROVED ) values (1, '판매자1', '1234', '1234','내일의 집', TRUE);
INSERT INTO Seller (seller_id, name, s_Id, store_Name, IS_APPROVED ) values (2, '판매자2', '155234', '오늘의 집', FALSE);

INSERT INTO Admin (ADMIN_ID , A_ID , NAME , PWD ) values (1, '1234', '관리자1','1234');

INSERT INTO DELIVERY (DELIVERY_ID , DELIVERY_STATUS ) VALUES (1, 0);
INSERT INTO DELIVERY (DELIVERY_ID , DELIVERY_STATUS) VALUES (2, 1);
INSERT INTO DELIVERY (DELIVERY_ID , DELIVERY_STATUS ) VALUES (3, 0);

INSERT INTO ORDERS  (ORDER_ID, ORDER_DATE , CONSUMER_ID) VALUES (1, '20221010', 1);
INSERT INTO ORDERS  (ORDER_ID, ORDER_DATE , CONSUMER_ID) VALUES (2, '20221011', 1);
INSERT INTO ORDERS  (ORDER_ID, ORDER_DATE , CONSUMER_ID) VALUES (3, '20221012', 1);

INSERT INTO CATEGORY( CATEGORY_ID , CATEGORY_NAME ) values (1, '가방');

INSERT INTO ITEM (ITEM_ID  , NAME , PRICE , SELLER_ID,STOCK_QUANTITY, UPLOADFILE_ID, CATEGORY_ID) VALUES (1, '가방', 1000, 1, 100, 1, 1);
INSERT INTO ITEM  (ITEM_ID , NAME , PRICE , SELLER_ID, STOCK_QUANTITY, UPLOADFILE_ID, CATEGORY_ID) VALUES (2, '옷', 4000, 1, 150, 1, 1);

INSERT INTO ORDER_ITEM  (ORDERITEM_ID,COUNT ,ORDER_PRICE ,ITEM_ID ,ORDER_ID,DELIVERY_ID ,ORDER_ITEM_STATUS ) VALUES (1, 1, 1000, 1, 1,1,1);
INSERT INTO ORDER_ITEM  (ORDERITEM_ID,COUNT ,ORDER_PRICE ,ITEM_ID ,ORDER_ID ,DELIVERY_ID ,ORDER_ITEM_STATUS ) VALUES (2, 1, 1000, 1, 1,2,0);
INSERT INTO ORDER_ITEM  (ORDERITEM_ID,COUNT ,ORDER_PRICE ,ITEM_ID ,ORDER_ID ,DELIVERY_ID ,ORDER_ITEM_STATUS) VALUES (3, 1, 1000, 2, 2,3,2);
INSERT INTO ORDER_ITEM  (ORDERITEM_ID ,COUNT ,ORDER_PRICE ,ITEM_ID ,ORDER_ID ,DELIVERY_ID ,ORDER_ITEM_STATUS ) VALUES (4, 1, 1000, 2, 3,1,1);

INSERT INTO REVIEW (REVIEW_ID, CONTENT , REVIEW_DATE , CONSUMER_ID , ITEM_ID ) VALUES (5, '정말 좋아요', '20221010', 1, 1 );
INSERT INTO REVIEW (REVIEW_ID, CONTENT , REVIEW_DATE , CONSUMER_ID , ITEM_ID ) VALUES (6, '정말 이뻐요', '20211010', 1, 2 );