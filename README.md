![Screenshot from 2023-08-19 19-13-22](https://github.com/abhi-10001/Electricity-Billing-System/assets/98804705/4032e2a3-9991-41a9-8604-151e2696eaf6)
![Screenshot from 2023-08-19 19-13-11](https://github.com/abhi-10001/Electricity-Billing-System/assets/98804705/ac89c132-4cca-4d93-a99f-92bc3c9933df)
![Screenshot from 2023-08-19 19-12-59](https://github.com/abhi-10001/Electricity-Billing-System/assets/98804705/920edf44-a827-4a69-8f48-d98d6232e132)
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

![Screenshot from 2023-08-19 19-09-53](https://github.com/abhi-10001/Electricity-Billing-System/assets/98804705/853ca45a-0117-4f90-8264-7e806270ea12)
![Screenshot from 2023-08-19 18-54-37](https://github.com/abhi-10001/Electricity-Billing-System/assets/98804705/9dff5ebc-bd3c-4981-aa68-965f74648d34)
![Screenshot from 2023-08-19 19-08-03](https://github.com/abhi-10001/Electricity-Billing-System/assets/98804705/9547ac46-a625-417b-b51d-e22cbc968480)
![Screenshot from 2023-08-19 19-07-35](https://github.com/abhi-10001/Electricity-Billing-System/assets/98804705/37d0eed3-6789-4891-b6b0-3470b3b11441)
![Screenshot from 2023-08-19 18-54-37](https://github.com/abhi-10001/Electricity-Billing-System/assets/98804705/709c0fc6-c925-4932-bcbe-dfee194bf488)
![Screenshot from 2023-08-19 18-54-17](https://github.com/abhi-10001/Electricity-Billing-System/assets/98804705/c4c27d49-6e44-4403-b231-120ed67f551e)

