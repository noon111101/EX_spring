CREATE database EX03_Mysql;
USE EX03_Mysql;
CREATE TABLE tbl_kho (
ID int NOT NULL  ,
ma_kho varchar(50) NOT NULL,
ten varchar(50) NOT NULL,
dia_diem varchar(50) NOT NULL,
ngay_tao date,
ngay_sua date,
PRIMARY KEY (ma_kho) );

CREATE TABLE tbl_loai_danh_muc (
ID int NOT NULL  ,
ma_loai_danh_muc varchar(50) NOT NULL,
ten varchar(50) NOT NULL,
mo_ta varchar(50) NOT NULL,
ngay_tao date,
ngay_sua date,
PRIMARY KEY (ma_loai_danh_muc) );

CREATE TABLE tbl_san_pham (
ID int NOT NULL  ,
ma_san_pham varchar(50) NOT NULL,
ten varchar(50) NOT NULL,
danh_muc varchar(50) NOT NULL,
kho varchar(50),
mo_ta_san_pham varchar(50),
duong_dan_anh varchar(50),
so_luong_san_pham int NOT NULL,
so_luong_ban int NOT NULL,
gia float ,
ngay_tao date,
ngay_sua date,
PRIMARY KEY (ma_san_pham),
foreign key (danh_muc)
 REFERENCES tbl_loai_danh_muc(ma_loai_danh_muc),
 foreign key (kho)
 REFERENCES tbl_kho(ma_kho));

SELECT * from tbl_kho;
SELECT * from tbl_loai_danh_muc;
SELECT * from tbl_san_pham;


INSERT INTO tbl_kho (ID,ma_kho,ten,dia_diem,ngay_tao,ngay_sua)
VALUES ("1", "K1","Kho1","HaNoi",11/11/2020,10/12/2020);
INSERT INTO tbl_loai_danh_muc (ID,ma_loai_danh_muc,ten,mo_ta,ngay_tao,ngay_sua)
VALUES ("1", "DM1","DanhMuc1","Tao",11/11/2020,10/12/2020);
INSERT INTO tbl_san_pham (ID,ma_san_pham,ten,danh_muc,kho,mo_ta_san_pham,duong_dan_anh,so_luong_san_pham,so_luong_ban,gia,ngay_tao,ngay_sua)
VALUES ("1","SP1","SanPham1","DM1","K1","Tao my","http:///","10","7","15.000",11/11/2020,10/12/2020);


UPDATE tbl_kho SET ten="kho2" WHERE ID=1;
UPDATE tbl_loai_danh_muc SET ten="danh2" WHERE ID=1;
UPDATE tbl_san_pham SET ten="sp2" WHERE ID=1;


DELETE FROM tbl_kho WHERE ID=1;

SELECT *
FROM tbl_san_pham SP JOIN tbl_loai_danh_muc DM
ON SP.danh_muc=DM.ma_loai_danh_muc
WHERE SP.mo_ta_san_pham = 'Dien thoai' AND DM.mo_ta= 'Apple';

SELECT danh_muc,count(danh_muc) as so_luong_san_pham 
FROM tbl_san_pham
GROUP BY danh_muc
order by so_luong_san_pham ;


SET autocommit = 0;
START TRANSACTION;
DELETE FROM tbl_loai_danh_muc WHERE ma_loai_danh_muc='DM1';
DELETE FROM tbl_san_pham
WHERE EXISTS
  (SELECT *
  FROM tbl_loai_danh_muc
  WHERE tbl_loai_danh_muc.ma_loai_danh_muc = tbl_san_pham.danh_muc);
COMMIT;
ROLLBACK;





