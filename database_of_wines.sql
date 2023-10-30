create database wines_shop;
use wines_shop;


create table `role`(
id_role bigint auto_increment primary key,
name_role varchar(255) null
);
INSERT INTO wines_shop.role (id_role, name_role) VALUES (1, 'ROLE_USER');
INSERT INTO wines_shop.role (id_role, name_role) VALUES (2, 'ROLE_ADMIN');

create table type_wines (
id_type_wines bigint auto_increment primary key,
name_type_wines varchar(255) null
);
INSERT INTO wines_shop.type_wines (id_type_wines, name_type_wines) VALUES (1, 'Brandy');
INSERT INTO wines_shop.type_wines (id_type_wines, name_type_wines) VALUES (2, 'Rum');
INSERT INTO wines_shop.type_wines (id_type_wines, name_type_wines) VALUES (3, 'Whisky');
INSERT INTO wines_shop.type_wines (id_type_wines, name_type_wines) VALUES (4, 'Vodka');
INSERT INTO wines_shop.type_wines (id_type_wines, name_type_wines) VALUES (5, 'Tequila');
INSERT INTO wines_shop.type_wines (id_type_wines, name_type_wines) VALUES (6, 'Gin');

create table `account`(
id_account bigint auto_increment primary key,
email      varchar(255) null,
full_name  varchar(255) null,
password   varchar(255) null,
id_role    bigint       null,
foreign key (id_role) references role (id_role)
);
INSERT INTO wines_shop.account (id_account, email, full_name, password, id_role) VALUES (1, 'olapree0@marriott.com', 'Ofilia Lapree', '$2a$10$w40pm.ynAz.gfMYGhPvNPOiGTBQbYSbjA59nxsTr0iIXDC.QwciAS', 1);
INSERT INTO wines_shop.account (id_account, email, full_name, password, id_role) VALUES (2, 'thanh@gmail.com', 'Thanh', '$2a$10$w40pm.ynAz.gfMYGhPvNPOiGTBQbYSbjA59nxsTr0iIXDC.QwciAS', 1);

create table wines (
id_wines bigint not null primary key,
description_wines   longtext     null,
alcohol             int          null,
color_wines         varchar(255) null,
country_manufacture varchar(255) null,
flag_wines          bit          null,
flavor_wines        varchar(255) null,
image_wines         varchar(255) null,
manufacture_wines   varchar(255) null,
name_wines          varchar(255) null,
price_wines         double       null,
quantity            int          null,
id_type_wines       bigint       null,
foreign key (id_type_wines) references type_wines (id_type_wines)
);
INSERT INTO wines_shop.wines (id_wines, description_wines, alcohol, color_wines, country_manufacture, flag_wines, flavor_wines, image_wines, manufacture_wines, name_wines, price_wines, quantity, id_type_wines)
 VALUES (1, 'Bacardi 151 rum bottle has a luxurious and classy design. The bottle is tall and slim, made from dark brown glass, helping to protect the wine from sunlight and keep the flavor intact.
The mouth of the bottle has a red plastic screw cap, making it sturdy and convenient to use. The Bacardi 151 rum bottle label has a simple but outstanding design. The main colors of the label are red, black, and white. In the center of the bottle label is the Bacardi logo with the word “BACARDI” written in black letters on a white background. Below is the word "151" written in red letters on a white background, symbolizing the product\'s 151 proof alcohol content.
At the top of the label is an image of a powerful eagle printed in black on a red background. Overall, the Bacardi 151 rum bottle is a beautifully designed and fully featured product, creating the perfection and class of a high quality rum.', 75, 'Dark brown, caramel, orange-red', 'Hamilton', false, 'Rich, Spicy, Bitter, Uniquely strong', 'images/prod-1.jpg', 'Barcadi Limited', 'Barcardi 151', 220, 99, 1);
INSERT INTO wines_shop.wines (id_wines, description_wines, alcohol, color_wines, country_manufacture, flag_wines, flavor_wines, image_wines, manufacture_wines, name_wines, price_wines, quantity, id_type_wines)
 VALUES (2, 'Jim Beam White (Jim Beam White), Jim Beam is the number 1 Bourbon Whiskey brand in the world today. Founded in 1795, wine producer Jim Beam has experienced 7 generations of operation in this field. Jim Beam is honored as America\'s national drink.
To be called Bourbon, alcohol must comply with American law. Bourbon is a type of Whiskey that must be produced from at least 51% corn, usually used as a corn ingredient of about 65% to 75% in the brewing water. There is also a legally prescribed storage period of 2 years in new white oak barrels, charred inside. The use of new oak barrels, which gives a large part of Bourbon\'s taste, was not actually used for taste reasons, but at the beginning of the 20th century, the government wanted to provide economic assistance to underdeveloped areas with many forests ( for example, Arkansas). Bourbon Whiskey matures after just a few years thanks to the new wood of the barrel and the climatic conditions of the production area. The name comes from Bourbon County in Kentucky.', 40, 'Light yellow color', 'Kentucky', false, 'Characteristic flavors of Vanilla, Honey and Oak', 'images/prod-2.jpg', 'Jim Beam', 'Jim Beam Kentucky Straight', 165, 100, 3);
INSERT INTO wines_shop.wines (id_wines, description_wines, alcohol, color_wines, country_manufacture, flag_wines, flavor_wines, image_wines, manufacture_wines, name_wines, price_wines, quantity, id_type_wines)
 VALUES (3, 'Glenlivet is a pure product line, belonging to the Single Malt Scotch Whiskey style. This brand is headquartered in Speyside Scotland. This land has a very cool, humid climate, and has pure spring water from the Livet valley. Those are the strengths that help the wines from here have excellent flavors and conquer even the most demanding customers.
The Glenlivet is a comprehensive blend of many flavors. The most characteristic feature is the sweet fruit taste. Dried fruits, grapes, pears, apples and citrus are the richest. Not only that, some versions also have a deep, sweet pineapple flavor. In addition, each version has a distinctive, spicy oak flavor that permeates the tongue.', 44, '
amber yellow, honey yellow or bright yellow', 'Speyside Scotland', false, 'Green apple, Orange, Tangerine, Floral, oak, Pineapple', 'images/prod-4.jpg', 'The Glenlivet', 'Glenlivet', 66, 100, 3);
INSERT INTO wines_shop.wines (id_wines, description_wines, alcohol, color_wines, country_manufacture, flag_wines, flavor_wines, image_wines, manufacture_wines, name_wines, price_wines, quantity, id_type_wines)
 VALUES (4, 'Johnnie Walker Black Label is the darling of Johnnie Walker. This child has brought Johnnie Walker to the heights of the world for nearly 200 years. With the standard of mixing more than 40 types of premium Whiskey with a minimum age of 12 years or more in the famous country of Scotland. Johnnie Walker Black Label has become a whiskey recognized by beverage experts as the standard of high-end whiskey.', 40, 'amber yellow', 'Scotland', false, 'Sweet, passionate and deep, Vanilla, dried fruit flavor', 'images/prod-5.jpg', 'Johnnie Walker', 'Black Label', 50, 100, 3);
INSERT INTO wines_shop.wines (id_wines, description_wines, alcohol, color_wines, country_manufacture, flag_wines, flavor_wines, image_wines, manufacture_wines, name_wines, price_wines, quantity, id_type_wines) 
VALUES (5, 'Macallan 15 Year Color Collection - in The Macallan Color collection exclusively released for global retail travel channels.
Macallan releases The Macallan Color collection, marking the return of age-graded whiskeys to the brand\'s global travel retail (GTR) channel.
This collection includes 5 Single malt whiskeys 12, 15, 18, 21 and 30 years old. The brand says that this product line displays the natural color obtained from many years of aging in Sherry oak barrels (including American oak barrels and European oak barrels).', 43, 'natural', 'Scotland', false, 'Sherry Oak, Chocolate, Cinnamon, Licorice, Nutmeg and Sweet and Sour flavors of plum.
', 'images/prod-6.jpg', 'Macallan', 'Macallan', 450, 100, 3);
INSERT INTO wines_shop.wines (id_wines, description_wines, alcohol, color_wines, country_manufacture, flag_wines, flavor_wines, image_wines, manufacture_wines, name_wines, price_wines, quantity, id_type_wines) 
VALUES (6, 'Old Monk Rum is an iconic vatted Indian dark rum, launched in 1954.[1] It is a dark rum with a distinct vanilla flavour, with an alcohol content of 42.8%.[2] It is produced in Ghaziabad, Uttar Pradesh and have registered office in Solan, Himachal Pradesh.
There is no advertising, its popularity depends on word of mouth and loyalty of customers.[3] However, in 2013 Old Monk lost its rank as the largest selling dark rum to McDowell\'s No.1 Celebration Rum.[4] Old Monk has been the biggest Indian Made Foreign Liquor (IMFL) brand for many years.[5]', 42, 'Brown-black', 'Indian', false, 'Vani', 'images/prod-7.jpg', 'Ghaziabad , Uttar Pradesh', 'Old Mock', 50, 100, 2);
INSERT INTO wines_shop.wines (id_wines, description_wines, alcohol, color_wines, country_manufacture, flag_wines, flavor_wines, image_wines, manufacture_wines, name_wines, price_wines, quantity, id_type_wines)
 VALUES (7, 'In the early 19th century, Jameson Irish Whiskey was exported to countries around the world. With its easy-to-drink taste, today Jameson Irish Whiskey has become the best-selling whiskey in the world.
Following market trends, targeting young customers, the wine is designed with the main appearance being the green color of fresh dynamism. The Jameson wine brand aims to become a brand of modernity and newness.
Normally, Whiskey/Whiskey is distilled twice, but Jameson Irish Whiskey is different. It is distilled 3 times to create its special flavor. One of the factors contributing to the smooth flavor is the diverse ingredients. Coongju enjoys the liberal mindset of the manufacturers, helping the Jameson brand become a favorite brand.
Jameson Irish Whiskey has a green exterior and the interior color is dark amber yellow. You will immediately faint with the aroma of cherry and delicate wood smell.', 40, '
dark amber yellow', 'Ireland', false, 'Smoothness,Sweetness,Mellow Fruits', 'images/prod-8.jpg', 'Ailen Distillers', 'Jameson Irish Whiskey', 35, 100, 3);
INSERT INTO wines_shop.wines (id_wines, description_wines, alcohol, color_wines, country_manufacture, flag_wines, flavor_wines, image_wines, manufacture_wines, name_wines, price_wines, quantity, id_type_wines)
 VALUES (8, 'It was first distilled in 1780 by John Jameson, who founded his distillery in Dublin in that same year. From very early on, Jameson was aware it would be essential to select only the best barley and casks and to keep the whole operation within a single distillery. The distillery was originally known as the Steins Family Bow Street Distiller. While the name has since changed, the location of the distillery remains the same today. 
The profile of the Jameson whiskey is indicative of the blending techniques known to other whiskeys aged in various kinds of casks, and that is one reason why it remains such a delicious and popular whiskey for so many people all over the world.
It wasn’t until 1968 that Jameson whiskey was sold by the bottle. Before this date, Jameson whiskey was only available by the cask. However, since the 60’s, it has been updated and is now known as a bottled whiskey like any other.', 44, '
bright and transparent color', 'France', false, 'Aromas of herbs, spices and a bit of fresh fruit. Prominent aromas of juniper flowers and pepper give this gin its character.', 'images/prod-3.jpg', 'Cognac Ferrand', 'Citadelle', 38, 100, 3);
INSERT INTO wines_shop.wines (id_wines, description_wines, alcohol, color_wines, country_manufacture, flag_wines, flavor_wines, image_wines, manufacture_wines, name_wines, price_wines, quantity, id_type_wines) 
VALUES (9, 'Jägermeister is a herbal liqueur (Kräuterlikör). It closely resembles other European liqueurs, such as Gammel Dansk of Denmark, Făt-Frumos and Nucul de Aur of Moldova, Beerenburg of the Netherlands, Unicum of Hungary, Becherovka of the Czech Republic, Gorzka Żołądkowa of Poland Lan, Demänovka of Slovakia, Pelinkovac of Croatia, Riga Black Balsam of Latvia, Gorki List of Serbia, Fernet-Branca of Italy, Licor Beirão of Portugal and Chartreuse and Bénédictine of France. Unlike these drinks, Jägermeister has a sweeter taste. Even in Germany, there are many competing brands such as Killepitsch, Kuemmerling, Schierker Feuerstein, Schwartshog, Wurzelpeter and Underberg, some of which are as sweet as Jägermeister.
', 35, 'Dark brown/gold', 'Germany', false, '
56 herbs and spices', 'images/ruou-jagermeiter.jpg', 'Mast-Jägermeister SE', 'Jagermeister', 40, 100, 2);
INSERT INTO wines_shop.wines (id_wines, description_wines, alcohol, color_wines, country_manufacture, flag_wines, flavor_wines, image_wines, manufacture_wines, name_wines, price_wines, quantity, id_type_wines) 
VALUES (10, 'This Napoleon Brandy is a product of a traditional French brandy brand. The ingredients that make the wine are carefully selected and then mixed with meticulousness.
Next, the wine is aged in small oak barrels and supervised by expert blenders. That\'s why this spirit has perfect smoothness and great balance in flavor.', 37, 'Light amber with hints of gold', 'France', false, 'dried fruit spices and oak', 'images/chatelle-napoleon-brandy.jpg', ' Cognac house Camus', 'Chetelle Napoleon rare French Brandy', 50, 97, 1);

create table customer(
id_customer bigint auto_increment primary key,
address_customer varchar(255) null,
day_of_birth     date         null,
email_customer   varchar(255) null,
flag_customer    bit          null,
gender_customer  varchar(255) null,
name_customer    varchar(255) null,
tel_customer     varchar(255) null,
id_account       bigint       null,
foreign key (id_account) references account (id_account)
);
INSERT INTO wines_shop.customer (id_customer, address_customer, day_of_birth, email_customer, flag_customer, gender_customer, name_customer, tel_customer, id_account)
 VALUES (1, '023 Atwood Terrace', '2000-08-15', 'olapree0@marriott.com', false, 'Female', 'Ofilia Lapree', '7775044819', 1);
INSERT INTO wines_shop.customer (id_customer, address_customer, day_of_birth, email_customer, flag_customer, gender_customer, name_customer, tel_customer, id_account)
 VALUES (2, '023 Atwood Terrace', '2000-08-15', 'thanh@gmail.com', false, 'Female', 'Thanh', '7775044819', 2);

create table employee (
id_employee bigint auto_increment primary key,
address_employee varchar(255) null,
day_of_birth     date         null,
email_employee   varchar(255) null,
flag_employee    bit          null,
gender_employee  varchar(255) null,
name_employee    varchar(255) null,
tel_employee     varchar(255) null,
id_account       bigint       null,
foreign key (id_account) references account (id_account)
);
create table orders(
    id_order bigint auto_increment primary key,
    date_order  datetime(6) null,
    status      bit         null,
    id_customer bigint      null,
    total_price double      not null,
	foreign key (id_customer) references customer (id_customer)
);
INSERT INTO wines_shop.orders (id_order, date_order, status, id_customer, total_price) VALUES (12, '2023-10-11 17:26:12.000000', false, 1, 1);
INSERT INTO wines_shop.orders (id_order, date_order, status, id_customer, total_price) VALUES (13, '2023-10-07 17:26:12.948000', null, 1, 1);
INSERT INTO wines_shop.orders (id_order, date_order, status, id_customer, total_price) VALUES (14, '2023-10-15 17:29:16.100000', null, 1, 1);
INSERT INTO wines_shop.orders (id_order, date_order, status, id_customer, total_price) VALUES (15, '2023-10-19 17:31:27.446298', null, 1, 1);
INSERT INTO wines_shop.orders (id_order, date_order, status, id_customer, total_price) VALUES (16, '2023-10-14 20:06:02.332000', null, 1, 1);
INSERT INTO wines_shop.orders (id_order, date_order, status, id_customer, total_price) VALUES (17, '2023-10-19 20:08:16.525717', null, 1, 250);
INSERT INTO wines_shop.orders (id_order, date_order, status, id_customer, total_price) VALUES (18, '2023-10-12 20:14:02.511000', false, 1, 452);
INSERT INTO wines_shop.orders (id_order, date_order, status, id_customer, total_price) VALUES (19, '2023-10-19 20:16:48.119909', false, 1, 452);
INSERT INTO wines_shop.orders (id_order, date_order, status, id_customer, total_price) VALUES (20, '2023-10-12 20:17:54.713000', false, 1, 452);
INSERT INTO wines_shop.orders (id_order, date_order, status, id_customer, total_price) VALUES (21, '2023-10-19 20:19:08.808912', false, 1, 452);


create table cart(
    id_cart bigint auto_increment primary key,
    quality     int    null,
    status      bit    null,
    id_customer bigint null,
    id_wines    bigint null,
    constraint cart_index
	unique (id_customer, id_wines),
	foreign key (id_customer) references customer (id_customer),
	foreign key (id_wines) references wines (id_wines)
);
INSERT INTO wines_shop.cart (id_cart, quality, status, id_customer, id_wines) VALUES (9, 1, false, 2, 13);

create table order_details(
    id_order_details bigint auto_increment primary key,
    current_price    double null,
    quality          int    null,
    id_orders        bigint null,
    id_wines         bigint null,	
	foreign key (id_orders) references orders (id_order),
	foreign key (id_wines) references wines (id_wines)
);
INSERT INTO wines_shop.order_details (id_order_details, current_price, quality, id_orders, id_wines) VALUES (1, 250, 5, 15, 10);
INSERT INTO wines_shop.order_details (id_order_details, current_price, quality, id_orders, id_wines) VALUES (2, 250, 5, 17, 10);
INSERT INTO wines_shop.order_details (id_order_details, current_price, quality, id_orders, id_wines) VALUES (3, 452, 2, 18, 3);
INSERT INTO wines_shop.order_details (id_order_details, current_price, quality, id_orders, id_wines) VALUES (4, 452, 2, 18, 7);
INSERT INTO wines_shop.order_details (id_order_details, current_price, quality, id_orders, id_wines) VALUES (5, 452, 5, 18, 10);
INSERT INTO wines_shop.order_details (id_order_details, current_price, quality, id_orders, id_wines) VALUES (6, 250, 5, 22, 10);
INSERT INTO wines_shop.order_details (id_order_details, current_price, quality, id_orders, id_wines) VALUES (7, 70, 2, 22, 7);
INSERT INTO wines_shop.order_details (id_order_details, current_price, quality, id_orders, id_wines) VALUES (8, 132, 2, 22, 3);
INSERT INTO wines_shop.order_details (id_order_details, current_price, quality, id_orders, id_wines) VALUES (9, 70, 2, 23, 7);
INSERT INTO wines_shop.order_details (id_order_details, current_price, quality, id_orders, id_wines) VALUES (10, 132, 2, 23, 3);

