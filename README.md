## Installation

Step 1: clone the github repository.
```bash
git clone https://github.com/abhi-10001/Electricity-Billing-System.git
```
Step 2: Install MySql database and MySql Client (You can either use GUI-client like WorkBench or stick to CLI-client ).

Step 3: While installing MySql database you have to set the username and password of local database client as below (you can change the username and password from the project in the "src/electricity/billing/system/Conn.java line:11 " into whatever you like)

```bash
username = "root" and password = "root"
```

Step 4: Run some SQL queries one by one.  

```bash
create database electricitybillingsystem;
```
```bash
create table bill(meter_no varchar(20), month varchar(30), units varchar(30), totalbill varchar(20), status varchar(20));
```

```bash
create table meter_info(meter_no varchar(20), meter_location varchar(20), meter_type varchar(20), phase_code varchar(20), bill_type varchar(20), days varchar(20));

```
```bash
create table customer(name varchar(50), meter_no varchar(20), address varchar(100), city varchar(30), state varchar(30), email varchar(50), phone varchar(20));

```
```bash
create table login(meter_no varchar(20), username varchar(40), name varchar(50), password varchar(30), user varchar(20));
```
```bash
create table tax(cost_per_unit varchar(20), meter_rent varchar(20), service_charge varchar(20), service_tax varchar(20), swacch_bharat_cess varchar(20),
fixed_tax varchar(20));

```

Step 5: You have to add some data to 'tax' table in order to calculate and generate bill. Write the below data to table 'tax'.

```bash
insert into tax values('9','47','22','57','6','18');
```

## Run the project

To run the project you have to successfully complete above all 5 steps and then run the Splash.java file.

If you stuck see my profile.


## Some Project Screenshots

![Screenshot from 2023-08-19 18-54-17](https://github.com/abhi-10001/Electricity-Billing-System/assets/98804705/4eca6e3a-0b17-4914-ab0f-8f5c262c38a1)


![Screenshot from 2023-08-19 18-54-37](https://github.com/abhi-10001/Electricity-Billing-System/assets/98804705/c45ca73f-7d27-49c1-a395-7ae349a928bd)


![Screenshot from 2023-08-19 19-07-35](https://github.com/abhi-10001/Electricity-Billing-System/assets/98804705/d13f89f1-5a23-46ec-82b1-3f9e29c89e22)


![Screenshot from 2023-08-19 19-08-03](https://github.com/abhi-10001/Electricity-Billing-System/assets/98804705/dbeaa6e1-fff9-46e9-8f22-cb5bf5c56bd2)


![Screenshot from 2023-08-19 19-09-37](https://github.com/abhi-10001/Electricity-Billing-System/assets/98804705/480f2669-2455-4641-a9bf-99fc2aaec352)


![Screenshot from 2023-08-19 19-09-53](https://github.com/abhi-10001/Electricity-Billing-System/assets/98804705/8ad3a14d-0699-4de4-86ce-662843e06bbe)


![Screenshot from 2023-08-19 19-13-11](https://github.com/abhi-10001/Electricity-Billing-System/assets/98804705/33c58c02-4b3c-4fff-acc2-08e43fd6bd67)




