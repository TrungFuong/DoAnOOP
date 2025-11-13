use Gym
go 

create table Accounts (
AccountId varchar(20) primary key,
AccountPw varchar(255),
Salt varchar(255),
Rol int
)

create table Staffs (
StaffId varchar(20) primary key,
StaffName nvarchar(50),
StaffPhone varchar(15),
StaffEmail varchar(20),
StaffDOB date,
StaffGender bit,
StaffStatus bit,
AccountId varchar(20),
foreign key (AccountId) references Accounts(AccountId)
)

create table Trainers (
TrainerId varchar(20) primary key,
TrainerName nvarchar(50),
TrainerEmail varchar(50),
TrainerPhone varchar(15),
TrainerDOB date,
TrainerStatus int,
TrainerGender bit,
AccountId varchar(20),
foreign key (AccountId) references Accounts(AccountId)
)

create table Packages (
PackageId varchar(20) primary key,
PackageName nvarchar(255),
PackageDuration int,
PackagePrice decimal(18,2),
PackageDescription nvarchar(255),
)

create table Members(
MemberId varchar(20) primary key,
MemberName nvarchar(50),
MemberPhone varchar(15),
MemberDOB date,
MemberEmail varchar(50),
MemberImage varchar(255),
)

create table Sess(
Sessiondate date,
EndTime time,
StartTime time,
Sta int,
TrainerId varchar(20),
foreign key (TrainerId) references Trainers(TrainerId),
MemberId varchar(20),
foreign key (MemberId) references Members(MemberId),
PackageId varchar(20),
foreign key (PackageId) references Packages(PackageId),
)

create table MemberPackages(
StartDate Date,
EndDate Date,
Sta int,
TrainerId varchar(20)
foreign key (TrainerId) references Trainers(TrainerId),
MemberId varchar(20),
foreign key (MemberId) references Members(MemberId),
PackageId varchar(20),
foreign key (PackageId) references Packages(PackageId),
)




-- 1. Accounts
insert into Accounts (AccountId, AccountPw, Salt, Rol) values
('ACC01', 'hashedpw1', 'salt1', 1),
('ACC02', 'hashedpw2', 'salt2', 2),
('ACC03', 'hashedpw3', 'salt3', 2),
('ACC04', 'hashedpw4', 'salt4', 3),
('ACC05', 'hashedpw5', 'salt5', 3);

-- 2. Staffs
insert into Staffs (StaffId, StaffName, StaffPhone, StaffEmail, StaffDOB, StaffGender, StaffStatus, AccountId) values
('ST01', N'Nguyễn Văn An', '0901234567', 'an@gym.com', '1995-03-15', 1, 1, 'ACC01'),
('ST02', N'Lê Thị Bình', '0907654321', 'binh@gym.com', '1998-09-20', 0, 1, 'ACC02');

-- 3. Trainers
insert into Trainers (TrainerId, TrainerName, TrainerEmail, TrainerPhone, TrainerDOB, TrainerStatus, TrainerGender, AccountId) values
('TR01', N'Trần Hữu Phát', 'phat@gym.com', '0911111111', '1992-06-10', 1, 1, 'ACC03'),
('TR02', N'Nguyễn Minh Anh', 'anh@gym.com', '0922222222', '1997-12-25', 1, 0, 'ACC04');

-- 4. Packages
insert into Packages (PackageId, PackageName, PackageDuration, PackagePrice, PackageDescription) values
('PK01', N'Gói 1 tháng', 30, 500000, N'Tập tự do trong 1 tháng'),
('PK02', N'Gói 3 tháng', 90, 1200000, N'Tập cùng huấn luyện viên trong 3 tháng'),
('PK03', N'Gói 6 tháng', 180, 2100000, N'Tập nâng cao cho thành viên lâu dài');

-- 5. Members
insert into Members (MemberId, MemberName, MemberPhone, MemberDOB, MemberEmail, MemberImage) values
('MB01', N'Phạm Quốc Khánh', '0933333333', '2000-04-10', 'khanh@mail.com', 'khanh.jpg'),
('MB02', N'Lê Thảo Vy', '0944444444', '1999-11-20', 'vy@mail.com', 'vy.jpg'),
('MB03', N'Nguyễn Đức Long', '0955555555', '1998-02-14', 'long@mail.com', 'long.jpg');

-- 6. MemberPackages
insert into MemberPackages (StartDate, EndDate, Sta, TrainerId, MemberId, PackageId) values
('2025-10-01', '2025-10-30', 1, 'TR01', 'MB01', 'PK01'),
('2025-09-01', '2025-11-30', 1, 'TR02', 'MB02', 'PK02'),
('2025-06-01', '2025-12-01', 0, 'TR01', 'MB03', 'PK03');

-- 7. Sess (Các buổi tập)
insert into Sess (Sessiondate, StartTime, EndTime, Sta, TrainerId, MemberId, PackageId) values
('2025-10-02', '08:00', '09:00', 1, 'TR01', 'MB01', 'PK01'),
('2025-10-03', '08:00', '09:00', 1, 'TR01', 'MB01', 'PK01'),
('2025-09-05', '18:00', '19:30', 1, 'TR02', 'MB02', 'PK02'),
('2025-11-01', '07:30', '08:30', 0, 'TR01', 'MB03', 'PK03');
