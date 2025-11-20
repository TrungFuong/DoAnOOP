use
Gym
go

create table Accounts
(
    AccountId varchar(20) primary key,
    AccountPw varchar(255),
    Salt      varchar(255),
    Role      int
);

create table Staffs
(
    StaffId     varchar(20) primary key,
    StaffName   nvarchar(50),
    StaffPhone  varchar(15),
    StaffEmail  varchar(50),
    StaffDOB    date,
    StaffGender bit,
    StaffStatus bit,
    AccountId   varchar(20),
    foreign key (AccountId) references Accounts (AccountId)
);

create table Trainers
(
    TrainerId     varchar(20) primary key,
    TrainerName   nvarchar(50),
    TrainerEmail  varchar(50),
    TrainerPhone  varchar(15),
    TrainerDOB    date,
    TrainerStatus int,
    TrainerGender bit,
    AccountId     varchar(20),
    foreign key (AccountId) references Accounts (AccountId)
);

create table MembershipPackages
(
    PackageId          varchar(20) primary key,
    PackageName        nvarchar(255),
    PackageDuration    int,
    PackagePrice       decimal(18, 2),
    PackageDescription nvarchar(255)
);

create table Members
(
    MemberId    varchar(20) primary key,
    MemberName  nvarchar(50),
    MemberPhone varchar(15),
    MemberDOB   date,
    MemberEmail varchar(50),
    MemberImage varchar(255)
);

create table Sess
(
    SessionDate date,
    StartTime   time,
    MemberId    varchar(20),
    PackageId   varchar(20),

    foreign key (MemberId) references Members (MemberId),
    foreign key (PackageId) references MembershipPackages (PackageId),

    primary key (SessionDate, StartTime, MemberId, PackageId)
);

create table MemberPackages
(
    StartDate Date,
    EndDate   Date,
    Sta       int,
    MemberId  varchar(20),
    PackageId varchar(20),

    foreign key (MemberId) references Members (MemberId),
    foreign key (PackageId) references MembershipPackages (PackageId),

    primary key (MemberId, PackageId)
);

create table PTPackages
(
    PackageId       varchar(20) primary key,
    PackageName     nvarchar(255),
    PackageDuration int,
    PackagePrice    decimal(18, 2),
    Description     nvarchar(255),
    TrainerId       varchar(20),
    foreign key (TrainerId) references Trainers (TrainerId)
);

create table MemberPTPackages
(
    StartDate Date,
    EndDate   Date,
    Sta       int,
    MemberId  varchar(20),
    PackageId varchar(20),

    foreign key (MemberId) references Members (MemberId),
    foreign key (PackageId) references PTPackages (PackageId),

    primary key (MemberId, PackageId)
);

create table PTSessions
(
    SessionDate date,
    StartTime   time,
    EndTime     time,
    Sta         int,

    MemberId    varchar(20),
    PackageId   varchar(20),

    TrainerId   varchar(20),

    foreign key (TrainerId) references Trainers (TrainerId),

    foreign key (MemberId, PackageId)
        references MemberPTPackages (MemberId, PackageId),

    primary key (SessionDate, StartTime, MemberId, PackageId, TrainerId)
);

create table MembershipCards
(
    CardId   varchar(20) primary key,
    Sta      int,
    MemberId varchar(20) not null,
    foreign key (MemberId) references Members (MemberId)
);

