-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: hotel_managment_website
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `booking_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `RoomID` int NOT NULL,
  `check_in_date` date NOT NULL,
  `check_out_date` date DEFAULT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `fk_customer_id` (`customer_id`),
  KEY `fk_RoomID` (`RoomID`),
  CONSTRAINT `fk_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `fk_RoomID` FOREIGN KEY (`RoomID`) REFERENCES `room` (`RoomID`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,1,21,'2023-09-01','2023-09-04','Trả phòng'),(2,2,19,'2023-09-05','2023-09-08','Trả phòng'),(3,3,18,'2023-09-10','2023-09-13','Trả phòng'),(4,4,17,'2023-09-15','2023-09-18','Trả phòng'),(5,5,16,'2023-09-20','2023-09-23','Trả phòng'),(6,6,15,'2023-09-25','2023-09-28','Trả phòng'),(7,7,14,'2023-10-01','2023-10-04','Trả phòng'),(8,8,13,'2023-10-05','2023-10-08','Trả phòng'),(9,9,12,'2023-10-10','2023-10-13','Trả phòng'),(10,10,11,'2023-10-15','2023-10-18','Trả phòng'),(11,11,10,'2023-10-20','2023-10-23','Trả phòng'),(12,12,9,'2023-10-25','2023-10-28','Trả phòng'),(13,13,8,'2023-11-01','2023-11-04','Trả phòng'),(14,14,7,'2023-11-05','2023-11-08','Trả phòng'),(15,15,6,'2023-11-10','2023-11-13','Trả phòng'),(16,16,5,'2023-11-15','2023-11-18','Trả phòng'),(17,17,4,'2023-11-20','2023-11-23','Trả phòng'),(18,18,3,'2023-11-25','2023-11-28','Trả phòng'),(19,19,2,'2023-12-01','2023-12-04','Trả phòng'),(20,20,1,'2023-12-05','2023-12-08','Trả phòng'),(21,21,5,'2024-01-01','2024-01-04','Trả phòng'),(22,22,11,'2024-01-05','2024-01-08','Trả phòng'),(23,23,4,'2024-01-10','2024-01-13','Trả phòng'),(24,24,7,'2024-01-15','2024-01-18','Trả phòng'),(25,25,26,'2024-01-20','2024-01-23','Trả phòng'),(26,26,25,'2024-01-25','2024-01-28','Trả phòng'),(27,27,24,'2024-02-01','2024-02-04','Trả phòng'),(28,28,23,'2024-02-05','2024-02-08','Trả phòng'),(29,29,22,'2024-02-10','2024-02-13','Trả phòng'),(30,30,21,'2024-02-15','2024-02-18','Trả phòng'),(31,31,20,'2024-02-20','2024-02-23','Trả phòng'),(32,32,19,'2024-02-25','2024-02-28','Trả phòng'),(33,33,18,'2024-03-01','2024-03-04','Trả phòng'),(34,34,17,'2024-03-05','2024-03-08','Trả phòng'),(35,35,16,'2024-03-10','2024-03-13','Trả phòng'),(36,36,15,'2024-03-15','2024-03-18','Trả phòng'),(37,37,14,'2024-03-20','2024-03-23','Trả phòng'),(38,38,13,'2024-03-25','2024-03-28','Trả phòng'),(39,39,12,'2024-04-01','2024-04-04','Trả phòng'),(40,40,11,'2024-04-05','2024-04-08','Trả phòng'),(41,41,10,'2024-05-01',NULL,'Nhận phòng'),(42,42,9,'2024-05-05',NULL,'Nhận phòng'),(43,43,8,'2024-05-10','2024-05-14','Trả phòng'),(44,44,7,'2024-05-15',NULL,'Nhận phòng'),(45,45,6,'2024-05-20',NULL,'Nhận phòng'),(46,74,5,'2024-05-25',NULL,'Nhận phòng'),(47,47,4,'2024-05-30','2024-06-03','Trả phòng'),(48,48,3,'2024-06-04',NULL,'Nhận phòng'),(49,49,2,'2024-06-09',NULL,'Nhận phòng'),(50,50,1,'2024-06-14',NULL,'Nhận phòng'),(51,79,13,'2024-06-19',NULL,'Nhận phòng'),(52,74,17,'2024-06-21',NULL,'Nhận phòng'),(59,78,23,'2024-06-23',NULL,'Nhận phòng'),(62,50,12,'2024-06-23',NULL,'Nhận phòng'),(63,49,8,'2024-06-27',NULL,'Nhận phòng');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(100) DEFAULT NULL,
  `customer_pass` varchar(100) DEFAULT NULL,
  `customer_fullname` varchar(45) NOT NULL,
  `customer_birthday` varchar(45) DEFAULT NULL,
  `customer_mobilephone` varchar(45) NOT NULL,
  `customer_email` varchar(100) DEFAULT NULL,
  `customer_gender` varchar(45) DEFAULT NULL,
  `customer_nationality` varchar(45) DEFAULT NULL,
  `customer_ID_number` varchar(12) DEFAULT NULL,
  `customer_address` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `customer_ID_number_UNIQUE` (`customer_ID_number`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'nguyenhongsac','137160a6fcdc573645012c177f143d67','Nguyễn Hồng Sắc','20/03/2012','0383890203','nguyenhongsaac@gmail.com','Nam','Việt Nam','001264875309','Hà Nội'),(2,'patient','b39024efbc6de61976f585c8421c6bba','Chung Gia Lập','25/07/1993','0802513887','chunggialap7371@gmail.com','Nam','Việt Nam','002347610295','Xã Nhơn Phú, Huyện Mang Thít, Vĩnh Long'),(3,'tethanhnguyen82','997b1600b933e3a64e0541d63ef9b954','Tề Thành Nguyên','04/01/1997','0711657513','tethanhnguyen82@gmail.com','Nam','Việt Nam','003965421078','Phường Nghĩa Tân, Thị xã Gia Nghĩa, Đắc Nông'),(4,'lophuocnhan545','13862d1252dcc2a819bc195a696022e6','Lộ Phước Nhân','01/06/1990','0712616444','lophuocnhan545@gmail.com','Nam','Việt Nam','004217589036','Phường 1, Thị xã Vĩnh Châu, Sóc Trăng'),(5,'tangquyetthang941','95a29f300037281ee6aac766959ab170','Tăng Quyết Thắng','15/09/1997','0851537331','tangquyetthang941@gmail.com','Nam','Việt Nam','005698742103','Phường Thuận Hòa, Thành phố Huế, Thừa Thiên Huế'),(6,'lactrangai701','5bf081d724842107a4e7f57d41c334d6','Lạc Trang Ðài','28/12/1995','0935959315','lactrangai701@gmail.com','Nam','Việt Nam','006547812390','Phường 2, Thành phố Đà Lạt, Lâm Đồng'),(7,'hinhhoaitrung680','e11a37d42d7b9b64cc80d7ce445e5286','Hình Hoài Trung','06/07/1993','0883386917','hinhhoaitrung680@gmail.com','Nam','Việt Nam','007856329014','Xã Gia Hòa 2, Huyện Mỹ Xuyên, Sóc Trăng'),(8,'dankieutrang860','b37137d053ac7b4be9ab9510b3353a94','Đan Kiều Trang','17/06/1990','0749176483','dankieutrang860@gmail.com','Nữ','Việt Nam','008732941605','Xã Hòa Phú, Huyện Chư Păh, Gia Lai'),(9,'suvietha658','a5f373c3b053aaf6e9c62d80f641ed3d','Sử Việt Hà','03/11/1992','0904333103','suvietha658@gmail.com','Nam','Việt Nam','009865742301','Xã Đoàn Lập, Huyện Tiên Lãng, Hải Phòng'),(10,'theminhnhu670','c0eba78c6aeb8c29626a942249cfe176','Thế Minh Như','23/06/1999','0724607775','theminhnhu670@gmail.com','Nữ','Việt Nam','001032954876','Xã Nam Dong, Huyện Cư Jút, Đắc Nông'),(11,'sonkieuloan134','35ca31113cd155383c51994c68a2ffd4','Sơn Kiều Loan','14/02/1989','0864521127','sonkieuloan134@gmail.com','Nữ','Việt Nam','001147856209','Xã Hưng Mỹ, Huyện Châu Thành, Trà Vinh'),(12,'thapvietquyet445','ddc002c2939a81b449e16879f13979b5','Thập Việt Quyết','08/07/1998','0553813823','thapvietquyet445@gmail.com','Nam','Việt Nam','001297845603','Xã An Lão, Huyện Bình Lục, Hà Nam'),(13,'hoangdiemhuong57','568e8e2382c8db321bc39dad14a74ca0','Hoàng Diễm Hương','14/03/1990','0844110040','hoangdiemhuong57@gmail.com','Nữ','Việt Nam','001368742590','Xã Phước Hà, Huyện Thuận Nam, Ninh Thuận'),(14,'hconghao838','5916d5f09a3f3f453607004bf8127285','H\' Công Hào','25/09/1991','0820119566','hconghao838@gmail.com','Nam','Việt Nam','001476295038','Xã Thuần Mang, Huyện Ngân Sơn, Bắc cạn'),(15,'giaotuyethuong471','46548c4aee9a0c35bb70c265732bec82','Giao Tuyết Hương','21/01/1989','0755215669','giaotuyethuong471@gmail.com','Nữ','Việt Nam','001589630274','Phường Đông Sơn, Thị xã Bỉm Sơn, Thanh Hóa'),(16,'cailienkiet468','4af26b8c7a2dae2defe32c1c2e82bdc3','Cai Liên Kiệt','12/07/1998','0705098748','cailienkiet468@gmail.com','Nam','Việt Nam','001678935420','Xã Triệu Thượng, Huyện Triệu Phong, Quảng Trị'),(17,'viemduycuong250','8edfae80ae818c85b32cbe5dc0cb407b','Viêm Duy Cương','27/06/1989','0556233897','viemduycuong250@gmail.com','Nam','Việt Nam','001789654302','Xã Ea H\'MLay, Huyện M\'Đrắk, Đắc Lắc'),(18,'vothanhthuy743','52eed641774f1828fbec054294c27521','Võ Thanh Thúy','28/09/1997','0937833927','vothanhthuy743@gmail.com','Nữ','Việt Nam','001824769035','Thị trấn Vĩnh Lộc, Huyện Chiêm Hóa, Tuyên Quang'),(19,'vanconghoan458','57c8b3084586f72eb510e891a33aff60','Vạn Công Hoán','16/01/1993','0890959845','vanconghoan458@gmail.com','Nam','Việt Nam','001987456023','Phường Hưng Thạnh, Quận Cái Răng, Cần Thơ'),(20,'thucchikien755','aaeecfdaab99ccefec2591032708c7db','Thục Chí Kiên','11/01/2000','0312077402','thucchikien755@gmail.com','Nam','Việt Nam','002037894156','Xã Đức Xuyên, Huyện Krông Nô, Đắc Nông'),(21,'xungtronghieu607','31b4100233cd4a051859586fd8618200','Xung Trọng Hiếu','27/01/1988','0384486158','xungtronghieu607@gmail.com','Nam','Việt Nam','002146830975','Xã Thạch Bàn, Huyện Thạch Hà, Hà Tĩnh'),(22,'thithanhthien424','99c20a4fbf1b8c71b62a8b92e62541de','Thi Thanh Thiên','19/10/1992','0900052265','thithanhthien424@gmail.com','Nam','Việt Nam','002298745103','Xã Lỗ Sơn, Huyện Tân Lạc, Hoà Bình'),(23,'trieuxuannhi100','c36068ef558ec9b6b8de5162be7104ed','Triệu Xuân Nhi','08/07/1989','0752625825','trieuxuannhi100@gmail.com','Nữ','Việt Nam','002368451097','Xã Sa Lông, Huyện Mường Chà, Điện Biên'),(24,'xungthanhnguyen93','b8b5650fdaeae64c75a196956d248381','Xung Thanh Nguyên','10/09/1999','0971665688','xungthanhnguyen93@gmail.com','Nam','Việt Nam','002475690831','Xã Sùng Đô, Huyện Văn Chấn, Yên Bái'),(25,'sammyhuyen680','16e879f9c0736cca3e61579b00457a2b','Sầm Mỹ Huyền','25/05/2000','0712886246','sammyhuyen680@gmail.com','Nữ','Việt Nam','002589630174','Xã Đào Viên, Huyện Quế Võ, Bắc Ninh'),(26,'lahongque270','72e1dbc523fc3f004bf37850a0975f7c','Lã Hồng Quế','01/02/1997','0580328450','lahongque270@gmail.com','Nữ','Việt Nam','002697854310','Xã Suối Nghệ, Huyện Châu Đức, Bà Rịa - Vũng Tàu'),(27,'huongthucanh976','f37194de288fbd23d4e8198a36288efa','Hướng Thục Anh','15/12/1993','0502561316','huongthucanh976@gmail.com','Nữ','Việt Nam','002789631540','Phường Suối Hoa, Thành phố Bắc Ninh, Bắc Ninh'),(28,'duongtrungnghia210','39c6e68dadb71c98aaf189e61211bbf6','Đường Trung Nghĩa','14/09/2000','0528538819','duongtrungnghia210@gmail.com','Nam','Việt Nam','002879654310','Xã Bình Khánh, Huyện Cần Giờ, Hồ Chí Minh (tphcm)'),(29,'trinhminhvy611','3d745e51d109e579f3613831b70876d2','Trịnh Minh Vy','23/04/1997','0802657255','trinhminhvy611@gmail.com','Nữ','Việt Nam','002934765810','Xã Thạnh Lộc, Huyện Vĩnh Thạnh, Cần Thơ'),(30,'bactheminh20','3abce0931aca13aba297c659d39335f4','Bạc Thế Minh','02/10/1999','0936005609','bactheminh20@gmail.com','Nam','Việt Nam','003047692158','Xã Tiên Hà, Huyện Tiên Phước, Quảng Nam'),(31,'lucbaoan889','0a81d45dea485126e8d34d67d0b1eedd','Lục Bảo An','08/01/1994','0880935195','lucbaoan889@gmail.com','Nam','Việt Nam','003156827940','Xã Xuân Thành, Huyện Xuân Lộc, Đồng Nai'),(32,'daumongnhi461','2d74af6d26254aa387e8602613b5f1a8','Đầu Mộng Nhi','27/10/1997','0975132259','daumongnhi461@gmail.com','Nữ','Việt Nam','003269875410','Phường Tứ Hạ, Thị xã Hương Trà, Thừa Thiên Huế'),(33,'sonquangat146','6ff9e79666e00a8d571a914a98cf0204','Sơn Quảng Ðạt','09/08/1996','0916187525','sonquangat146@gmail.com','Nam','Việt Nam','003387641290','Xã Liên Sang, Huyện Khánh Vĩnh, Khánh Hòa'),(34,'chebichhao799','ff71ebc95539873ba9c6ed120137b458','Chế Bích Hảo','17/07/1994','0319468557','chebichhao799@gmail.com','Nữ','Việt Nam','003495867210','Thị trấn Chư Sê, Huyện Chư Sê, Gia Lai'),(35,'hatamtrang72','33228bab4235e2210fabd95c2039d4fc','Hà Tâm Trang','19/07/1995','0921189840','hatamtrang72@gmail.com','Nữ','Việt Nam','003568471920','Thị trấn Bến Cầu, Huyện Bến Cầu, Tây Ninh'),(36,'dienthuylong648','0bdce484626ad104a01d4ee171fba7f9','Điền Thụy Long','12/05/1988','0982181937','dienthuylong648@gmail.com','Nam','Việt Nam','003687512094','Phường An Tảo, Thành phố Hưng Yên, Hưng Yên'),(37,'huongmaichi969','88bfab2b464d5f286626a35aa17a9cfe','Hướng Mai Chi','07/08/1993','0783021745','huongmaichi969@gmail.com','Nữ','Việt Nam','003798654210','Xã Ninh Hải, Huyện Hoa Lư, Ninh Bình'),(38,'viduythach152','39f942727dc13b8369db51150c3eadd8','Vi Duy Thạch','05/05/1991','0535792117','viduythach152@gmail.com','Nam','Việt Nam','003896742105','Xã Hưng Châu, Huyện Hưng Nguyên, Nghệ An'),(39,'quangxuannhi136','ee3624dbea710670148040b45eb6d5a9','Quàng Xuân Nhi','07/01/1995','0929620782','quangxuannhi136@gmail.com','Nữ','Việt Nam','003964875102','Xã Cúc Phương, Huyện Nho Quan, Ninh Bình'),(40,'suminhthuong384','a95ab24e541450cdfe1628277d783e95','Sử Minh Thương','07/05/1998','0947727257','suminhthuong384@gmail.com','Nữ','Việt Nam','004027698431','Xã Đắk Gằn, Huyện Đắk Mil, Đắc Nông'),(41,'matuyetoanh71','3006b1f1685259d441c3a0d38779ffa5','Ma Tuyết Oanh','22/12/1993','0784880431','matuyetoanh71@gmail.com','Nữ','Việt Nam','004136985207','Xã Tân Sơn, Huyện Lục Ngạn, Bắc Giang'),(42,'bachoangkhoi281','7135afce4b1bcff15f1498fbaaf6b38a','Bạc Hoàng Khôi','04/08/1992','0824285883','bachoangkhoi281@gmail.com','Nam','Việt Nam','004279654810','Phường Phố Cò, Thành phố Sông Công, Thái Nguyên'),(43,'ungxuankhoa55','7ed7b86ffdc98a95936d0608e21b6920','Ung Xuân Khoa','09/03/1996','0369632460','ungxuankhoa55@gmail.com','Nam','Việt Nam','004387562910','Xã Lơ Ku, Huyện KBang, Gia Lai'),(44,'khucduymanh215','b479eba5ecf635ff045387049c5b452a','Khúc Duy Mạnh','04/01/1996','0587667464','khucduymanh215@gmail.com','Nam','Việt Nam','004496875103','Xã Vân Sơn, Huyện Sơn Động, Bắc Giang'),(45,'linhhienhoa675','ce27fdd66a03d258da0d7de0830a2f81','Linh Hiền Hòa','29/06/1989','0380487578','linhhienhoa675@gmail.com','Nữ','Việt Nam','004569871320','Xã Tân Tiến, Huyện Tràng Định, Lạng Sơn'),(47,'capthientam315','15a141d6084652334d7eda07fdad82fc','Cáp Thiện Tâm','11/04/1998','0947576845','capthientam315@gmail.com','Nữ','Việt Nam','004798621530','Xã Thới Bình, Huyện Thới Bình, Cà Mau'),(48,'hmahoami166','07abbd2ffbfe4884abc06eead2681be9','H\'ma Họa Mi','18/11/1998','0856411285','hmahoami166@gmail.com','Nữ','Thái Lan','004869731205','Xã Cư KBang, Huyện Ea Súp, Đắc Lắc'),(49,'deohonggiang852','3f4f5369bab0c9fac3eab645be4f2070','Đèo Hồng Giang','26/10/1989','0385162386','deohonggiang852@gmail.com','Nữ','Việt Nam','004927654018','Xã Đài Xuyên, Huyện Vân Đồn, Quảng Ninh'),(50,'trinhbanmai4','eaebf9d4e329fa8e0a090b0486761a6d','Trình Ban Mai','27/12/1991','0883821949','trinhbanmai4@gmail.com','Nữ','Việt Nam','005036987410','Phường Mỹ Đông, Thành phố Phan Rang-Tháp Chàm, Ninh Thuận'),(74,'hungdx','3e2fce081e1d8dc306f3d88ecf55bffd','Đình Xuân Hưng','04/01/2003','03164665656','chienhon@gmail.com','Nam','Việt Nam','065623846','Hà Nội'),(78,'\" \"','\" \"','Nguyễn Thị Mai Hoa','30/3/1969','0398818396','hoa@gmail.com','Nữ','Việt Nam','06465713134','hà nội'),(79,'\" \"','\" \"','Đình Xuân Hải','25/7/1967','021316466','hai@gmail.com','Nam','Việt Nam','013131646413','Hà Nội');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `full_name` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `gender` varchar(45) NOT NULL,
  `position_id` int NOT NULL,
  `created_at` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `fk_position_id` (`position_id`),
  CONSTRAINT `fk_position_id` FOREIGN KEY (`position_id`) REFERENCES `position` (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'nvan','abc123!@#','Nguyễn Văn An','nvan@example.com','0901123456','Nam',1,'01/01/2023'),(2,'lthao','abc123!@#','Lê Thị Thảo','lthao@example.com','0901123457','Nữ',2,'02/01/2023'),(3,'pthuan','abc123!@#','Phạm Thị Thuận','pthuan@example.com','0901123458','Nữ',3,'03/01/2023'),(4,'dduong','abc123!@#','Đỗ Văn Dương','dduong@example.com','0901123459','Nam',4,'04/01/2023'),(5,'mthuy','abc123!@#','Mai Thị Thúy','mthuy@example.com','0901123460','Nữ',5,'05/01/2023'),(6,'tngoc','abc123!@#','Trần Ngọc Nguyên','tngoc@example.com','0901123461','Nam',6,'06/01/2023'),(7,'qkhoa','abc123!@#','Quách Khoa','qkhoa@example.com','0901123462','Nam',7,'07/01/2023'),(8,'pnga','abc123!@#','Phan Nga','pnga@example.com','0901123463','Nữ',1,'08/01/2023'),(9,'ttuan','abc123!@#','Trịnh Tuấn','ttuan@example.com','0901123464','Nam',2,'09/01/2023'),(10,'bhieu','abc123!@#','Bùi Hiếu','bhieu@example.com','0901123465','Nam',3,'10/01/2023'),(11,'nlan','abc123!@#','Nguyễn Lan','nlan@example.com','0901123466','Nữ',4,'11/01/2023'),(12,'hhanh','abc123!@#','Hoàng Hạnh','hhanh@example.com','0901123467','Nữ',5,'12/01/2023'),(13,'tmhieu','abc123!@#','Trần Minh Hiếu','tmhieu@example.com','0901123468','Nam',6,'13/01/2023'),(14,'lduong','abc123!@#','Lê Dương','lduong@example.com','0901123469','Nam',7,'14/01/2023'),(15,'pthao','abc123!@#','Phan Thị Thảo','pthao@example.com','0901123470','Nữ',1,'15/01/2023'),(16,'tdong','abc123!@#','Trương Đông','tdong@example.com','0901123471','Nam',2,'16/01/2023'),(17,'vlinh','abc123!@#','Vũ Linh','vlinh@example.com','0901123472','Nữ',3,'17/01/2023'),(18,'plinh','abc123!@#','Phạm Linh','plinh@example.com','0901123473','Nữ',4,'18/01/2023'),(19,'qtuan','abc123!@#','Quách Tuấn','qtuan@example.com','0901123474','Nam',5,'19/01/2023'),(20,'llinh','abc123!@#','Lý Linh','llinh@example.com','0901123475','Nữ',6,'20/01/2023'),(21,'bmhieu','abc123!@#','Bùi Minh Hiếu','bmhieu@example.com','0901123476','Nam',7,'21/01/2023'),(22,'ndiep','abc123!@#','Nguyễn Diệp','ndiep@example.com','0901123477','Nữ',1,'22/01/2023'),(23,'pnam','abc123!@#','Phạm Nam','pnam@example.com','0901123478','Nam',2,'23/01/2023'),(24,'tlien','abc123!@#','Trần Liên','tlien@example.com','0901123479','Nữ',3,'24/01/2023'),(25,'nkhai','abc123!@#','Ngô Khải','nkhai@example.com','0901123480','Nam',4,'25/01/2023'),(28,'hungdx','abc123!@#','Đình Xuân Hưng','hung@gmai.com','0349749410','Nam',1,'27/06/2024');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice` (
  `invoice_id` int NOT NULL AUTO_INCREMENT,
  `booking_id` int NOT NULL,
  `pay_date` varchar(45) DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`invoice_id`),
  KEY `fk_bookingid` (`booking_id`),
  CONSTRAINT `fk_bookingid` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`booking_id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (1,1,'2023-09-04',4700000,'Đã thanh toán'),(2,2,'2023-09-08',4150000,'Đã thanh toán'),(3,3,'2023-09-13',9400000,'Đã thanh toán'),(4,4,'2023-09-18',6800000,'Đã thanh toán'),(5,5,'2023-09-23',6800000,'Đã thanh toán'),(6,6,'2023-09-28',4900000,'Đã thanh toán'),(7,7,'2023-10-04',3700000,'Đã thanh toán'),(8,8,'2023-10-08',2400000,'Đã thanh toán'),(9,9,'2023-10-13',7500000,'Đã thanh toán'),(10,10,'2023-10-18',4500000,'Đã thanh toán'),(11,11,'2023-10-23',3600000,'Đã thanh toán'),(12,12,'2023-10-28',3600000,'Đã thanh toán'),(13,13,'2023-11-04',2400000,'Đã thanh toán'),(14,14,'2023-11-08',2400000,'Đã thanh toán'),(15,15,'2023-11-13',7500000,'Đã thanh toán'),(16,16,'2023-11-18',4500000,'Đã thanh toán'),(17,17,'2023-11-23',3600000,'Đã thanh toán'),(18,18,'2023-11-28',3600000,'Đã thanh toán'),(19,19,'2023-12-04',2400000,'Đã thanh toán'),(20,20,'2023-12-08',2400000,'Đã thanh toán'),(21,21,'2024-01-04',5600000,'Đã thanh toán'),(22,22,'2024-01-08',6250000,'Đã thanh toán'),(23,23,'2024-01-13',5500000,'Đã thanh toán'),(24,24,'2024-01-18',4700000,'Đã thanh toán'),(25,25,'2024-01-23',15200000,'Đã thanh toán'),(26,26,'2024-01-28',13300000,'Đã thanh toán'),(27,27,'2024-02-04',8800000,'Đã thanh toán'),(28,28,'2024-02-08',4500000,'Đã thanh toán'),(29,29,'2024-02-13',3600000,'Đã thanh toán'),(30,30,'2024-02-18',3600000,'Đã thanh toán'),(31,31,'2024-02-23',2400000,'Đã thanh toán'),(32,32,'2024-02-28',2400000,'Đã thanh toán'),(33,33,'2024-03-04',7500000,'Đã thanh toán'),(34,34,'2024-03-08',4500000,'Đã thanh toán'),(35,35,'2024-03-13',3600000,'Đã thanh toán'),(36,36,'2024-03-18',3600000,'Đã thanh toán'),(37,37,'2024-03-23',2400000,'Đã thanh toán'),(38,38,'2024-03-28',2400000,'Đã thanh toán'),(39,39,'2024-04-04',7500000,'Đã thanh toán'),(40,40,'2024-04-08',4500000,'Đã thanh toán'),(41,41,NULL,NULL,'Chưa thanh toán'),(42,42,NULL,NULL,'Chưa thanh toán'),(43,43,'2024-05-14',5100000,'Đã thanh toán'),(44,44,NULL,NULL,'Chưa thanh toán'),(45,45,NULL,NULL,'Chưa thanh toán'),(46,46,NULL,NULL,'Chưa thanh toán'),(47,47,'2024-06-03',6100000,'Đã thanh toán'),(48,48,NULL,NULL,'Chưa thanh toán'),(49,49,NULL,NULL,'Chưa thanh toán'),(50,50,NULL,NULL,'Chưa thanh toán'),(51,51,'2024-06-25',5100000,'Đã thanh toán'),(52,52,NULL,NULL,'Chưa thanh toán'),(59,59,NULL,NULL,'Chưa thanh toán'),(62,62,NULL,NULL,'Chưa thanh toán'),(63,63,'2024-06-27',100000,'Đã thanh toán');
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position` (
  `position_id` int NOT NULL AUTO_INCREMENT,
  `position_name` varchar(45) NOT NULL,
  PRIMARY KEY (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'Người quản lý'),(2,'Lễ tân'),(3,'Nhân viên dọn dẹp'),(4,'Nhân viên kỹ thuật'),(5,'Kế toán'),(6,'Nhân sự'),(7,'Bảo vệ');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `RoomID` int NOT NULL AUTO_INCREMENT,
  `RoomNumber` int DEFAULT NULL,
  `RoomTypeID` int NOT NULL,
  `Price` int NOT NULL,
  `Status` varchar(15) NOT NULL,
  `Images` varchar(500) DEFAULT ' ',
  `Reviews` varchar(50) DEFAULT NULL,
  `FloorRoom` int NOT NULL,
  `NumberOfBeds` int NOT NULL,
  `MaxOccupancy` int NOT NULL,
  `Area` float NOT NULL,
  `Amentities` varchar(200) NOT NULL,
  `NumberPhoneExtension` varchar(45) NOT NULL,
  `BookingHistory` varchar(45) NOT NULL,
  PRIMARY KEY (`RoomID`),
  KEY `fk_roomtype` (`RoomTypeID`),
  CONSTRAINT `fk_roomtype` FOREIGN KEY (`RoomTypeID`) REFERENCES `room_type` (`RoomTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,101,1,800000,'Trống',' ',NULL,1,1,2,20,'Wi-Fi, TV, Máy lạnh','101',''),(2,102,1,800000,'Đã đặt',' ',NULL,1,1,2,20,'Wi-Fi, TV, Máy lạnh','102',''),(3,103,2,1200000,'Trống',' ',NULL,1,2,4,35,'Wi-Fi, TV, Máy lạnh, Tủ lạnh','103',''),(4,104,2,1200000,'Đang dọn dẹp',' ',NULL,1,2,4,35,'Wi-Fi, TV, Máy lạnh, Tủ lạnh','104',''),(5,105,3,1500000,'Trống',' ',NULL,1,3,6,50,'Wi-Fi, TV, Máy lạnh, Tủ lạnh, Bếp nhỏ','105',''),(6,106,4,2500000,'Đã đặt',' ',NULL,1,1,2,25,'Wi-Fi, TV, Máy lạnh, Tủ lạnh, Bồn tắm','106',''),(7,201,1,800000,'Đang dọn dẹp',' ',NULL,2,1,2,20,'Wi-Fi, TV, Máy lạnh','201',''),(8,202,1,800000,'Trống',' ',NULL,2,1,2,20,'Wi-Fi, TV, Máy lạnh','202',''),(9,203,2,1200000,'Đã đặt',' ',NULL,2,2,4,35,'Wi-Fi, TV, Máy lạnh, Tủ lạnh','203',''),(10,204,2,1200000,'Trống',' ',NULL,2,2,4,35,'Wi-Fi, TV, Máy lạnh, Tủ lạnh','204',''),(11,205,3,1500000,'Đang dọn dẹp',' ',NULL,2,3,6,50,'Wi-Fi, TV, Máy lạnh, Tủ lạnh, Bếp nhỏ','205',''),(12,206,4,2500000,'Trống',' ',NULL,2,1,2,25,'Wi-Fi, TV, Máy lạnh, Tủ lạnh, Bồn tắm','206',''),(13,301,1,800000,'Trống',' ',NULL,3,1,2,20,'Wi-Fi, TV, Máy lạnh','301',''),(14,302,1,800000,'Đã đặt',' ',NULL,3,1,2,20,'Wi-Fi, TV, Máy lạnh','302',''),(15,303,2,1200000,'Trống',' ',NULL,3,2,4,35,'Wi-Fi, TV, Máy lạnh, Tủ lạnh','303',''),(16,304,2,1200000,'Đang dọn dẹp',' ',NULL,3,2,4,35,'Wi-Fi, TV, Máy lạnh, Tủ lạnh','304',''),(17,305,3,1500000,'Trống',' ',NULL,3,3,6,50,'Wi-Fi, TV, Máy lạnh, Tủ lạnh, Bếp nhỏ','305',''),(18,306,4,2500000,'Đã đặt',' ',NULL,3,1,2,25,'Wi-Fi, TV, Máy lạnh, Tủ lạnh, Bồn tắm','306',''),(19,401,1,800000,'Đang dọn dẹp',' ',NULL,4,1,2,20,'Wi-Fi, TV, Máy lạnh','401',''),(20,402,1,800000,'Trống',' ',NULL,4,1,2,20,'Wi-Fi, TV, Máy lạnh','402',''),(21,403,2,1200000,'Đã đặt',' ',NULL,4,2,4,35,'Wi-Fi, TV, Máy lạnh, Tủ lạnh','403',''),(22,404,2,1200000,'Trống',' ',NULL,4,2,4,35,'Wi-Fi, TV, Máy lạnh, Tủ lạnh','404',''),(23,405,3,1500000,'Đang dọn dẹp',' ',NULL,4,3,6,50,'Wi-Fi, TV, Máy lạnh, Tủ lạnh, Bếp nhỏ','405',''),(24,406,4,2500000,'Trống',' ',NULL,4,1,2,25,'Wi-Fi, TV, Máy lạnh, Tủ lạnh, Bồn tắm','406',''),(25,501,5,4000000,'Trống',' ',NULL,5,0,50,100,'Wi-Fi, TV, Máy lạnh, Âm thanh','501',''),(26,502,5,4000000,'Đã đặt',' ',NULL,5,0,50,100,'Wi-Fi, TV, Máy lạnh, Âm thanh','502','');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_type`
--

DROP TABLE IF EXISTS `room_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room_type` (
  `RoomTypeID` int NOT NULL AUTO_INCREMENT,
  `RoomTypeName` varchar(30) NOT NULL,
  `NumberOfRooms` int NOT NULL DEFAULT '0',
  `HourlyRate` int NOT NULL,
  `PriceByDay` int NOT NULL,
  `NightlyRate` int NOT NULL,
  PRIMARY KEY (`RoomTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_type`
--

LOCK TABLES `room_type` WRITE;
/*!40000 ALTER TABLE `room_type` DISABLE KEYS */;
INSERT INTO `room_type` VALUES (1,'Phòng đơn',0,100000,800000,700000),(2,'Phòng đôi',0,150000,1200000,1000000),(3,'Phòng gia đình',0,200000,1500000,1200000),(4,'Suite cao cấp',0,300000,2500000,2000000),(5,'Phòng hội nghị',0,500000,4000000,3000000);
/*!40000 ALTER TABLE `room_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `service_id` int NOT NULL AUTO_INCREMENT,
  `service_name` varchar(45) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'Dịch vụ đưa đón sân bay','Dịch vụ đưa đón khách hàng từ sân bay về khách sạn và ngược lại.',500000),(2,'Dịch vụ thuê xe du lịch','Dịch vụ cho thuê xe du lịch phục vụ đi lại và tham quan các địa điểm.',800000),(3,'Dịch vụ hướng dẫn viên du lịch','Dịch vụ cung cấp hướng dẫn viên du lịch đi cùng khách du lịch.',1000000),(4,'Dịch vụ đặt tour tham quan','Dịch vụ đặt tour tham quan các danh lam thắng cảnh trong thành phố.',600000),(5,'Dịch vụ thuê thuyền tham quan Hồ Gươm','Dịch vụ thuê thuyền để khám phá Hồ Gươm và các khu vực lân cận.',400000),(6,'Dịch vụ massage và spa','Dịch vụ massage và spa để thư giãn và nâng cao sức khỏe.',700000),(7,'Dịch vụ tổ chức tiệc cưới','Dịch vụ tổ chức tiệc cưới trong không gian sang trọng và tiện nghi.',2000000),(8,'Dịch vụ tổ chức hội nghị','Dịch vụ tổ chức hội nghị với đầy đủ thiết bị và không gian phù hợp.',1500000),(9,'Dịch vụ cho thuê phòng họp','Dịch vụ cho thuê phòng họp với các thiết bị hiện đại và tiện nghi.',500000),(10,'Dịch vụ thuê đồ vật dụng','Dịch vụ cho thuê các đồ vật dụng như máy chiếu, loa, micro.',300000),(11,'Dịch vụ giặt ủi nhanh','Dịch vụ giặt ủi nhanh gọn và chuyên nghiệp cho quần áo cá nhân.',100000),(12,'Dịch vụ phục vụ phòng 24/7','Dịch vụ phục vụ khách hàng tại phòng 24/7 theo yêu cầu.',400000),(13,'Dịch vụ phục vụ bữa sáng','Dịch vụ phục vụ bữa sáng tại nhà hàng hoặc phòng theo lựa chọn.',200000),(14,'Dịch vụ phục vụ bữa tối','Dịch vụ phục vụ bữa tối tại nhà hàng hoặc phòng theo lựa chọn.',300000),(15,'Dịch vụ phục vụ bữa trưa','Dịch vụ phục vụ bữa trưa tại nhà hàng hoặc phòng theo lựa chọn.',250000),(16,'Dịch vụ thuê áo dài','Dịch vụ cho thuê áo dài truyền thống để du xuân và chụp hình.',500000),(17,'Dịch vụ thuê phụ kiện cưới','Dịch vụ cho thuê phụ kiện cưới như váy cưới, hoa cài.',700000),(18,'Dịch vụ tư vấn du lịch','Dịch vụ tư vấn và lên kế hoạch du lịch cho khách hàng.',300000),(19,'Dịch vụ cho thuê địa điểm tổ chức sự kiện','Dịch vụ cho thuê địa điểm phù hợp để tổ chức các sự kiện.',1200000),(20,'Dịch vụ cho thuê dụng cụ nghệ thuật','Dịch vụ cho thuê dụng cụ nghệ thuật như đàn guitar, piano.',600000),(23,'Dịch vụ dọn dẹp phòng','Dịch vụ dọn dẹp phòng',200000);
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_usage`
--

DROP TABLE IF EXISTS `service_usage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_usage` (
  `usage_id` int NOT NULL AUTO_INCREMENT,
  `booking_id` int NOT NULL,
  `service_id` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`usage_id`),
  KEY `fk_booking_id` (`booking_id`),
  KEY `fk_service_id` (`service_id`),
  CONSTRAINT `fk_booking_id` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`booking_id`),
  CONSTRAINT `fk_service_id` FOREIGN KEY (`service_id`) REFERENCES `service` (`service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_usage`
--

LOCK TABLES `service_usage` WRITE;
/*!40000 ALTER TABLE `service_usage` DISABLE KEYS */;
INSERT INTO `service_usage` VALUES (1,1,12,1),(2,1,5,1),(3,1,18,1),(4,2,6,1),(5,2,2,1),(6,2,15,1),(7,3,4,1),(8,3,11,1),(9,3,19,1),(10,4,8,1),(11,4,1,1),(12,4,10,1),(13,5,3,1),(14,5,13,1),(15,5,7,1),(16,6,14,1),(17,6,9,1),(18,6,16,1),(19,7,17,1),(20,7,20,1),(21,21,12,1),(22,21,5,1),(23,21,18,1),(24,22,6,1),(25,22,2,1),(26,22,15,1),(27,23,4,1),(28,23,11,1),(29,23,19,1),(30,24,8,1),(31,24,1,1),(32,24,10,1),(33,25,3,1),(34,25,13,1),(35,25,7,1),(36,26,14,1),(37,26,9,1),(38,26,16,1),(39,27,17,1),(40,27,20,1),(41,41,12,1),(42,41,5,1),(43,41,18,1),(44,42,6,1),(45,42,2,1),(46,42,15,1),(47,43,4,1),(48,43,11,1),(49,43,19,1),(50,44,8,1),(51,44,1,1),(52,44,10,1),(53,45,3,1),(54,45,13,1),(55,45,7,1),(56,46,14,1),(57,46,9,1),(58,46,16,1),(59,47,17,1),(60,47,20,1),(61,48,12,1),(62,50,5,1),(63,49,18,1),(64,49,6,1),(65,49,2,1),(66,50,15,1),(67,50,4,1),(68,50,11,1),(69,48,19,1),(70,48,8,1),(71,50,2,1),(72,51,14,1),(73,52,11,2),(74,63,11,1);
/*!40000 ALTER TABLE `service_usage` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-28 15:52:06
