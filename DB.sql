drop database VirtualReality;
create database VirtualReality;
use VirtualReality;

create table GEN_GENRE (GEN_GENRE_ID int auto_increment primary key, GEN_GENRE_NAME varchar(20), GEN_DESCRITION varchar(100));

create table GAM_GAMES (GAM_GAME_ID int auto_increment primary key, GAM_GAME_NAME varchar(20), GAM_GENRE_ID int, foreign key(GAM_GENRE_ID) references GEN_GENRE(GEN_GENRE_ID));

create table ENV_ENVIRONMENT (ENV_ENV_ID int auto_increment primary key, ENV_ENV_NM varchar(20), ENV_GAME_ID int, foreign key(ENV_GAME_ID) references GAM_GAMES(GAM_GAME_ID));

create table PAR_PRTCPNT (PAR_PRTCPNT_ID int auto_increment primary key, PAR_PRTCPNT_NM varchar(100), PAR_GAME_ID int, foreign key(PAR_GAME_ID) references GAM_GAMES(GAM_GAME_ID), PAR_PLYNG_FLG int);

create table CHR_CHRCTRS (CHR_CHRCTR_ID int auto_increment primary key, CHR_GAME_ID int, CHR_CHRCTR_NM varchar(100) not null, CHR_CHRCTR_TYP varchar(20) not null, foreign key(CHR_GAME_ID) references GAM_GAMES(GAM_GAME_ID), check(CHR_CHRCTR_TYP = 'G' OR CHR_CHRCTR_TYP = 'B'));

create table WPN_WEAPONS (WPN_WEAPON_ID int auto_increment primary key, WPN_GAME_ID INT ,WPN_WEAPON_NM varchar(50), WPN_WEAPON_TYP varchar(20), WPN_WEAPON_DESC varchar(100), foreign key(WPN_GAME_ID) references GAM_GAMES(GAM_GAME_ID));
 
create table CHP_PRTCPNT_GAME (CHP_PRTPNT_GAME_ID int auto_increment primary key,CHP_PRTCPNT_ID  int, CHP_CHRCTR_ID int , HEAD_VIB_LVL int default 0,BODY_VIB_LVL int default 0, HIT_POINTS int, CHP_STATUS varchar(20), foreign key(CHP_PRTCPNT_ID) references PAR_PRTCPNT(PAR_PRTCPNT_ID), foreign key(CHP_CHRCTR_ID) references CHR_CHRCTRS(CHR_CHRCTR_ID));

create table GUN_GUNS (GUN_GUN_ID int auto_increment primary key, GUN_WEAPON_ID int, GUN_DESC varchar(100), GUN_MASS int, GUN_VEL int, GUN_NUMBER_OF_BULLETS int,VIB_LVL int, foreign key(GUN_WEAPON_ID) references WPN_WEAPONS(WPN_WEAPON_ID));

create table FLM_FLAME_THROWER (FLM_FLAME_THROWER_ID int auto_increment primary key, FLM_WEAPON_ID int, FLM_DESC varchar(100), FLM_INTENSITY int, FLM_TEMP int, foreign key(FLM_WEAPON_ID) references WPN_WEAPONS(WPN_WEAPON_ID));

create table RCK_ROCKET_LAUNCHER (RCK_ROCKET_LAUNCHER_ID int auto_increment primary key, RCK_WEAPON_ID int, RCK_DESC varchar(100), RCK_VEL int, RCK_NM_OF_RCKTS int, foreign key(RCK_WEAPON_ID) references WPN_WEAPONS(WPN_WEAPON_ID));

create table WIG_WEAPONS_GAME(WIG_WEAPONS_GAME_ID int auto_increment primary key, WIG_WEAPON_ID int , WIG_PRTCPNT_GAME_ID int, foreign key(WIG_WEAPON_ID) references WPN_WEAPONS(WPN_WEAPON_ID) , foreign key (WIG_PRTCPNT_GAME_ID) references CHP_PRTCPNT_GAME(CHP_PRTPNT_GAME_ID));

create table EVT_EVENTS_SHOOT(PRTCPNT_ID int, VBR_LVL int, VBR_AREA varchar(20), foreign key(PRTCPNT_ID) references par_prtcpnt(PAR_PRTCPNT_ID));

create table OUTPUT_TO_DEMULTIPLEXER(PLAYER_NUMBER_1 bit(1),PLAYER_NUMBER_2 bit(1),PLAYER_NUMBER_3 bit(1),PART_NUMBER_1 bit(1),PART_NUMBER_2 bit(1), VIBRATION_LVL_1 bit(1), VIBRATION_LVL_2 bit(1), VIBRATION_LVL_3 bit(1), primary key(PLAYER_NUMBER_1,PLAYER_NUMBER_2,PLAYER_NUMBER_3,PART_NUMBER_1,PART_NUMBER_2));


select * from PAR_PRTCPNT;
select * from CHP_PRTPNT_GAME;
select * from wpn_weapons;

select * from WIG_WEAPONS_GAME;

select * from gen_genre;
desc wig_weapons_game;
select * from CHR_CHRCTRS;
select * from EVT_EVENTS;

select * from GEN_GENRE;
desc chp_prtpnt_game;

select count(*) from chp_prtpnt_game;	

select * from GAM_GAMES;

insert into GEN_GENRE values (1,'Shooter games','Shooting');
insert into GEN_GENRE values (2,'Fighting games','Action');
insert into GEN_GENRE values (3,'Survival horor games','Horor');
insert into GEN_GENRE values (4,'Adventure games','Adventure');
insert into GEN_GENRE values (5,'Role Playing Games','Role Playing');

insert into GAM_GAMES values (1,'Gears of war',1);
insert into GAM_GAMES values (2,'GTA',2);
insert into GAM_GAMES values (3,'Resident Evil',3);
insert into GAM_GAMES values (4,'Prince Of persia',4);
insert into GAM_GAMES values (5,'DOTA',5);

insert into ENV_ENVIRONMENT values (1,'Nations of sera',1);
insert into ENV_ENVIRONMENT values (2,'cities',1);
insert into ENV_ENVIRONMENT values (3,'COG military bases',1);
insert into ENV_ENVIRONMENT values (4,'military bases',1);
insert into ENV_ENVIRONMENT values (5,'Locust base',1);
insert into ENV_ENVIRONMENT values (6,'UIR military bases',1);
insert into ENV_ENVIRONMENT values (7,'Medical facilities',1);
insert into ENV_ENVIRONMENT values (8,'Museums',1);

insert into PAR_PRTCPNT values (1,1,'Pooja');
insert into PAR_PRTCPNT values (2,1,'Naveen');
insert into PAR_PRTCPNT values (3,1,'Ganesh');
insert into PAR_PRTCPNT values (4,1,'Raja');
insert into PAR_PRTCPNT values (5,1,'Rakshitha');
insert into PAR_PRTCPNT values (6,1,'Nambi');
insert into PAR_PRTCPNT values (7,1,'Bhargav');
insert into PAR_PRTCPNT values (8,1,'Khavya');

insert into CHR_CHRCTRS values (1,'Marcus Fenix', 'g',1);
insert into CHR_CHRCTRS values (2,'Augustus Cole', 'g',1);
insert into CHR_CHRCTRS values (3,'Damon Baird', 'g',1);
insert into CHR_CHRCTRS values (4,'Anya Stroud', 'g',1);
insert into CHR_CHRCTRS values (5,'Myrrah jane', 'b',1);
insert into CHR_CHRCTRS values (6,'General Karn', 'b',1);
insert into CHR_CHRCTRS values (7,'Skorge Mephisto', 'b',1);
insert into CHR_CHRCTRS values (8,'Riftworm Diablo', 'b',1);

insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (1,1,'Armolite AR 50','Gun','Long range sniper rifile');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (2,1,'AWC g2','Gun','Bull pup sniper rifle');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (3,1,'Barrett M90','Gun','Bull pup sniper rifle');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (4,1,'Blaser R93','Gun','Hunting sniper');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC)values (5,1,'Cz700','Gun','Sniper rifle');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (6,1,'Kefefs','Gun','Sniper rifle');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (7,1,'M40','Gun','Sniper rifle');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (8,1,'MSSR','Gun','Rifle');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (9,1,'PGM 338','Gun','Sniper rifle');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (10,1,'Sacko TRG','Gun','Sniper rifle');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (11,1,'G3A3','Gun','Battle rifle');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (12,1,'AEK971','Gun','Asault rifle');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (13,1,'AK9','Gun','Asault rifle');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (14,1,'AK47','Gun','Asault rifle');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (15,1,'AK101','Gun','Asault rifle');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (16,1,'AK5','Gun','Asault rifle');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (17,1,'Heckler & Coch G11','Gun','Asault rifle');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (18,1,'LSAT','Gun','Asault rifle');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (19,1,'Remingnton  R5 RGB','Gun','Asault rifle');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (20,1,'SIG SG530','Gun','Asault rifle');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (21,1,'Astra','Gun','Revolver');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (22,1,'Beretta Stampede','Gun','Revolver');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (23,1,'Colt Buntline','Gun','Revolver');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (24,1,'colt cobra','Gun','Revolver');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (25,1,'Colt King Cobra','Gun','Revolver');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (26,1,'Colt Python','Gun','Revolver');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (27,1,'Korth Combat','Gun','Revolver');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (28,1,'Maurse Zigzag','Gun','Revolver');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (29,1,'Ruger LCR','Gun','Revolver');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (30,1,'Ultimate 500','Gun','Revolver');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (31,1,'Webley MK VI','Gun','Revolver');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (32,1,'Handflammpatrol','Flamethrower','null');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (33,1,'Harvey','Flamethrower','null');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (34,1,'LPO 50','Flamethrower','null');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (35,1,'M1 A1','Flamethrower','null');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (36,1,'M2','Flamethrower','null');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (37,1,'ROKS','Flamethrower','null');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (38,1,'Carl Gustaf','Rocket launcher','null');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (39,1,'Smaw','Rocket launcher','null');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (40,1,'RPG-16','Rocket launcher','null');
insert into WPN_WEAPONS(WPN_WEAPON_ID,gameId,WPN_WEAPON_NM,WPN_WEAPON_TYP,WPN_WEAPON_DESC) values (41,1,'M72-LAW','Rocket launcher','null');


insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (1,null,25,960,5);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (2,null,10,833,4);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (3,null,42,928,6);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (4,null,10,990,7);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (5,null,10,833,10);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (6,null,11,790,12);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (7,null,10,833,13);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (8,null,4,940,15);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (9,null,13,1005,20);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (10,null,16,897,10);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (11,null,11,790,11);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (12,null,4,880,14);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (13,null,17,280,17);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (14,null,8,730.3,20);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (15,null,4,905,10);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (16,null,4,936,16);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (17,null,8,730,15);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (18,null,4,905,12);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (19,null,4,936,14);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (20,null,4,936,25);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (21,null,7,300,12);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (22,null,8,440,12);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (23,null,15,290,18);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (24,null,6,219,18);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (25,null,10,220,12);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (26,null,12,430,12);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (27,null,10,210,12);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (28,null,10,220,12);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (29,null,2,700,12);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (30,null,19,632,12);
insert into GUN_GUNS(GUN_WEAPON_ID,GUN_DESC,GUN_MASS,GUN_VEL,GUN_NUMBER_OF_BULLETS) values (31,null,17,231,18);

insert into FLM_FLAME_THROWER(FLM_WEAPON_ID,FLM_DESC,FLM_INTENSITY,FLM_TEMP,AMMO) values (32,null,5,1300,4);
insert into FLM_FLAME_THROWER(FLM_WEAPON_ID,FLM_DESC,FLM_INTENSITY,FLM_TEMP,AMMO) values (33,null,4,1200,4);
insert into FLM_FLAME_THROWER(FLM_WEAPON_ID,FLM_DESC,FLM_INTENSITY,FLM_TEMP,AMMO) values (34,null,10.2,968,4);
insert into FLM_FLAME_THROWER(FLM_WEAPON_ID,FLM_DESC,FLM_INTENSITY,FLM_TEMP,AMMO) values (35,null,4.7,1000,4);
insert into FLM_FLAME_THROWER(FLM_WEAPON_ID,FLM_DESC,FLM_INTENSITY,FLM_TEMP,AMMO) values (36,null,7.4,1200,4);
insert into FLM_FLAME_THROWER(FLM_WEAPON_ID,FLM_DESC,FLM_INTENSITY,FLM_TEMP,AMMO) values (37,null,9,1265,4);

insert into RCK_ROCKET_LAUNCHER(RCK_WEAPON_ID,RCK_DESC,RCK_VEL,RCK_NM_OF_RCKTS) values (38,null,255,6);
insert into RCK_ROCKET_LAUNCHER(RCK_WEAPON_ID,RCK_DESC,RCK_VEL,RCK_NM_OF_RCKTS) values (39,null,220,1);
insert into RCK_ROCKET_LAUNCHER(RCK_WEAPON_ID,RCK_DESC,RCK_VEL,RCK_NM_OF_RCKTS) values (40,null,350,4);
insert into RCK_ROCKET_LAUNCHER(RCK_WEAPON_ID,RCK_DESC,RCK_VEL,RCK_NM_OF_RCKTS) values (41,null,145,1);
select * from CHP_PRTPNT_GAME;
select * from CHR_CHRCTRS;
select * from EVT_EVENTS;
select * from wig_weapons_game;
create table fuckyou(viration int);
SET SQL_SAFE_UPDATES = 0;

delimiter //

create procedure calcVibrationLevel()
begin
update GUN_GUNS
set VIB_LVL=GUN_MASS*GUN_VEL;
UPDATE GUN_GUNS
	set VIB_LVL=1 where VIB_LVL<10000;
UPDATE GUN_GUNS
	set VIB_LVL=2 where VIB_LVL<20000 AND VIB_LVL>10000;
UPDATE GUN_GUNS
	set VIB_LVL=3 where VIB_LVL<30000 AND VIB_LVL>20000;
UPDATE GUN_GUNS
	set VIB_LVL=4 where VIB_LVL<40000 AND VIB_LVL>30000;
end //
call calcVibrationLevel();//
select * from GUN_GUNS;//




create procedure calculate123(in GUN_MASS int, in GUN_VEL int, out VIB_LVL int)
BEGIN
	SET VIB_LVL = GUN_MASS*GUN_VEL;    
    IF(VIB_LVL<10000) THEN
    SET VIB_LVL = 1;
    end if;
    
    IF(VIB_LVL<30000 AND VIB_LVL>20000) THEN
    SET VIB_LVL = 3;
    end if;
    IF(VIB_LVL<20000 AND VIB_LVL>10000) THEN
    SET VIB_LVL = 2;
    end if;
    IF(VIB_LVL<40000 AND VIB_LVL>30000) THEN
    SET VIB_LVL = 4;
    end if;
END//



call calculate123(50,500,@vib_lvl);//
select @vib_lvl;//


drop procedure HITTED;//
create procedure HITTED(in x int, in y int, in A int, in B int, out hit bool,out flag varchar(20))
BEGIN
	declare R int default 10;
    if(power(x-A,2)+power(y-B,2)<=power(R,2)) then
		set hit=true;
        set flag='HEAD SHOT!';
	
	else if((x-2*R<=A)AND(x+2*R>=A)AND(y-R>=B)AND(y-7*R<=B)) then
		set hit=true;
        set flag='body';
     else 
		set hit=false;
        set flag='no hit';
     end if;
     end if;
END//






drop procedure HITTED1;//
create procedure HITTED1(in x int, in A int, in B int, out hit bool,out flag varchar(20))
BEGIN
	declare R int default 10;
    if(power(x-A,2)+power(70-B,2)<=power(R,2)) then
		set hit=true;
        set flag='Head';
	
	else if((x-2*R<=A)AND(x+2*R>=A)AND(70-R>=B)AND(70-7*R<=B)) then
		set hit=true;
        set flag='body';
     else 
		set hit=false;
        set flag='no hit';
     end if;
     end if;
END//

select * from EVT_EVENTS;//
create table EVT_EVENTS_SHOOT(PRTCPNT_ID int, VBR_LVL int, VBR_AREA varchar(20), foreign key(PRTCPNT_ID) references par_prtcpnt(PAR_PRTCPNT_ID));//
create table WPN_WEAPONS (WPN_WEAPON_ID int auto_increment primary key, WPN_GAME_ID INT ,WPN_WEAPON_NM varchar(50), WPN_WEAPON_TYP varchar(20), WPN_WEAPON_DESC varchar(100), foreign key(WPN_GAME_ID) references GAM_GAMES(GAM_GAME_ID));//
create table CHP_PRTCPNT_GAME (CHP_PRTPNT_GAME_ID int auto_increment primary key,CHP_PRTCPNT_ID  int, CHP_CHRCTR_ID int , HEAD_VIB_LVL int default 0,BODY_VIB_LVL int default 0, HIT_POINTS int, CHP_STATUS varchar(20), foreign key(CHP_PRTCPNT_ID) references PAR_PRTCPNT(PAR_PRTCPNT_ID), foreign key(CHP_CHRCTR_ID) references CHR_CHRCTRS(CHR_CHRCTR_ID));//

create table GUN_GUNS (GUN_GUN_ID int auto_increment primary key, GUN_WEAPON_ID int, GUN_DESC varchar(100), GUN_MASS int, GUN_VEL int, GUN_NUMBER_OF_BULLETS int,VIB_LVL int, foreign key(GUN_WEAPON_ID) references WPN_WEAPONS(WPN_WEAPON_ID));//

create table FLM_FLAME_THROWER (FLM_FLAME_THROWER_ID int auto_increment primary key, FLM_WEAPON_ID int, FLM_DESC varchar(100), FLM_INTENSITY int,VIB_LVL int, FLM_TEMP int, foreign key(FLM_WEAPON_ID) references WPN_WEAPONS(WPN_WEAPON_ID));//

create table RCK_ROCKET_LAUNCHER (RCK_ROCKET_LAUNCHER_ID int auto_increment primary key, RCK_WEAPON_ID int, RCK_DESC varchar(100), RCK_VEL int,VIB_LVL int, RCK_NM_OF_RCKTS int, foreign key(RCK_WEAPON_ID) references WPN_WEAPONS(WPN_WEAPON_ID));//

create table WIG_WEAPONS_GAME(WIG_WEAPONS_GAME_ID int auto_increment primary key, WIG_WEAPON_ID int , WIG_PRTCPNT_GAME_ID int, foreign key(WIG_WEAPON_ID) references WPN_WEAPONS(WPN_WEAPON_ID) , foreign key (WIG_PRTCPNT_GAME_ID) references CHP_PRTCPNT_GAME(CHP_PRTPNT_GAME_ID));//

drop table EVT_EVENTS_SHOOT;//



desc GUN_GUNS;//
drop trigger shot;//
create trigger shot after insert on EVT_EVENTS for each row
begin
	declare hitted bool;
    declare area varchar(20);
    call HITTED1(NEW.EVT_X,NEW.EVT_A,NEW.EVT_B,hitted,area);
    if(hitted=true) then
			set @wptype=(select WPN_WEAPON_TYP from WPN_WEAPONS where WPN_WEAPON_ID=NEW.EVT_WeaponID);
            if(@wptype='Gun')then
			set	@vib_lvl=(select VIB_LVL from GUN_GUNS where GUN_WEAPON_ID=NEW.EVT_WeaponID);
                 elseif(@wptype='Flamethrower')then
			set	@vib_lvl=(select VIB_LVL from FLM_FLAME_THROWER where FLM_WEAPON_ID=NEW.EVT_WeaponID);
		     elseif(@wptype='Rocket launcher')then
			set	@vib_lvl=(select VIB_LVL from RCK_ROCKET_LAUNCHER where RCK_WEAPON_ID=NEW.EVT_WeaponID);
		
		end if;
		insert into EVT_EVENTS_SHOOT values(NEW.EVT_PART_ID,@vib_lvl,area);
	end if;
end;//


select * from FLM_FLAME_THROWER;//










select * from EVT_EVENTS;//
select * from EVT_EVENTS_SHOOT;//
delete from EVT_EVENTS;//

delete from EVT_EVENTS_SHOOT;//
delete from WIG_WEAPONS_GAME;//
delete from CHP_PRTPNT_GAME;//




select * from RCK_ROCKET_LAUNCHER;//

update RCK_ROCKET_LAUNCHER set VIB_LVL=7;//









select * from EVT_EVENTS;//
select * from EVT_EVENTS_SHOOT;//
select * from CHP_PRTPNT_GAME;//
select * from WPN_WEAPONS;//
select count(*) from WIG_WEAPONS_GAME;//
select * from CHP_PRTPNT_GAME;//
select * from GUN_GUNS;//




select * from CHP_P;//

desc GEN_GENRE;//
desc GAM_GAMES;//
desc ENV_ENVIRONMENT;//
desc CHR_CHRCTRS;//
desc PAR_PRTCPNT;//
desc WPN_WEAPONS;//
desc GUN_GUNS;//
desc FLM_FLAME_THROWER;//
desc RCK_ROCKET_LAUNCHER;//

desc CHP_PRTPNT_GAME;//
desc WIG_WEAPONS_GAME;//
desc EVT_EVENTS;//
desc EVT_EVENTS_SHOOT;//
create view GAME_Summary as 
select p.PAR_PRTCPNT_NM,  ch.CHP_STATUS,  c.CHR_CHRCTCR_NM, c.CHR_CHRCTR_TYP
from PAR_PRTCPNT as p inner join CHP_PRTPNT_GAME as ch 
on p.PAR_PRTCPNT_ID = ch.partId inner join CHR_CHRCTRS as c
on c.CHR_CHRCTR_ID =ch.characterId ;//


create view GAME_Good as 
select p.PAR_PRTCPNT_NM,  ch.CHP_STATUS,  c.CHR_CHRCTCR_NM, c.CHR_CHRCTR_TYP
from PAR_PRTCPNT as p inner join CHP_PRTPNT_GAME as ch 
on p.PAR_PRTCPNT_ID = ch.partId inner join CHR_CHRCTRS as c
on c.CHR_CHRCTR_ID =ch.characterId where c.CHR_CHRCTR_TYP='g';//

create view GAME_BAD as 
select p.PAR_PRTCPNT_NM,  ch.CHP_STATUS,  c.CHR_CHRCTCR_NM, c.CHR_CHRCTR_TYP
from PAR_PRTCPNT as p inner join CHP_PRTPNT_GAME as ch 
on p.PAR_PRTCPNT_ID = ch.partId inner join CHR_CHRCTRS as c
on c.CHR_CHRCTR_ID =ch.characterId where c.CHR_CHRCTR_TYP='b';//

select * from GAME_Summary;//

update chp_prtpnt_game set CHP_STATUS = 'alive' where partId>4;//
select * from GAME_Good;//
select * from GAME_BAD;//

select 'Winner' as Result, 
case when (select count(*) from GAME_Summary WHERE CHR_CHRCTR_TYP ='g' and CHP_STATUS = 'Dead') = 4 then 'Bad Team'
when (select count(*) from GAME_Summary WHERE CHR_CHRCTR_TYP ='b' and CHP_STATUS = 'Dead') = 4 then 'Good Team' 
end as 'Team';//











select * from EVT_EVENTS_SHOOT;//
select * from CHP_PRTPNT_GAME;//

select * from WPN_WEAPONS;//

drop trigger health_change;//
create trigger health_change after insert on EVT_EVENTS_SHOOT for each row 
begin	
	if(NEW.VBR_AREA='Head') then 
		update CHP_PRTPNT_GAME
        set HIT_POINTS=HIT_POINTS-(32*NEW.VBR_LVL)
		where NEW.PRTCPNT_ID=partId;
        
        update CHP_PRTPNT_GAME
        set HEAD_VIB_LVL=HEAD_VIB_LVL+NEW.VBR_LVL
        where NEW.PRTCPNT_ID=partId;
		update CHP_PRTPNT_GAME
        set CHP_STATUS=IF(HIT_POINTS<0,'Dead','Alive');
        end if;
    
	if(NEW.VBR_AREA='body') then 
		update CHP_PRTPNT_GAME
        set HIT_POINTS=HIT_POINTS-(16*NEW.VBR_LVL)
        where NEW.PRTCPNT_ID=partId;
        update CHP_PRTPNT_GAME
        set BODY_VIB_LVL=BODY_VIB_LVL+NEW.VBR_LVL
        where NEW.PRTCPNT_ID=partId;
        update CHP_PRTPNT_GAME
        set CHP_STATUS=IF(HIT_POINTS<0,'Dead','Alive');
    end if;
end//



drop trigger Game_Over;//
create trigger Game_Over after update on CHP_PRTPNT_GAME for each row
begin
	declare goodguys int;
    declare badguys int;
        declare ifexists int;
		set ifexists=(select count(*) from OUTPUT_TO_DEMULTIPLEXER where PLAYER_NUMBER_1=floor(floor((NEW.CHP_PRTCPNT_ID-1)/4)%2) and PLAYER_NUMBER_2=floor(floor((NEW.CHP_PRTCPNT_ID-1)/2)%2) and PLAYER_NUMBER_3=floor((NEW.CHP_PRTCPNT_ID-1)%2));
    
		set goodguys=(select count(*) from CHR_CHRCTRS as Y inner join chp_prtcpnt_game as X on X.CHP_CHRCTR_ID=Y.CHR_CHRCTR_ID where Y.CHR_CHRCTR_TYP='G');
		set badguys=(select count(*) from CHR_CHRCTRS as Y inner join chp_prtcpnt_game as X on X.CHP_CHRCTR_ID=Y.CHR_CHRCTR_ID where Y.CHR_CHRCTR_TYP='B');
        insert into countguys values(goodguys);
        insert into countguys values(badguys);
        
        set goodguys=goodguys-(select count(*) from CHR_CHRCTRS as Y inner join chp_prtcpnt_game as X on X.CHP_CHRCTR_ID=Y.CHR_CHRCTR_ID where Y.CHR_CHRCTR_TYP='G' and X.CHP_STATUS='Dead');
		set badguys=badguys-(select count(*) from CHR_CHRCTRS as Y inner join chp_prtcpnt_game as X on X.CHP_CHRCTR_ID=Y.CHR_CHRCTR_ID where Y.CHR_CHRCTR_TYP='B' and X.CHP_STATUS='Dead');
		insert into countguys values(goodguys);
        insert into countguys values(badguys);
        
    if(goodguys=0) then
    insert into EVT_EVENTS_OUTCOME values('Good Team','LOSE!');
    insert into EVT_EVENTS_OUTCOME values('Bad Team','WIN!');
    end if;
    if(badguys=0) then
    insert into EVT_EVENTS_OUTCOME values('Bad Team','LOSE!');
    insert into EVT_EVENTS_OUTCOME values('Good Team','WINS!');
    end if;
    if(ifexists=2) then
        	update OUTPUT_TO_DEMULTIPLEXER
			set VIBRATION_LVL_3=floor(NEW.HEAD_VIB_LVL%2), VIBRATION_LVL_2=floor(floor(NEW.HEAD_VIB_LVL/2)%2),VIBRATION_LVL_1=floor(floor(NEW.HEAD_VIB_LVL/4)%2)
			where PART_NUMBER_2=0 and PART_NUMBER_1=0 and PLAYER_NUMBER_1=floor(floor((NEW.CHP_PRTCPNT_ID-1)/4)%2) and PLAYER_NUMBER_2=floor(floor((NEW.CHP_PRTCPNT_ID-1)/2)%2) and PLAYER_NUMBER_3=floor((NEW.CHP_PRTCPNT_ID-1)%2);
		update OUTPUT_TO_DEMULTIPLEXER
			set VIBRATION_LVL_3=floor(NEW.BODY_VIB_LVL%2), VIBRATION_LVL_2=floor(floor(NEW.BODY_VIB_LVL/2)%2),VIBRATION_LVL_1=floor(floor(NEW.BODY_VIB_LVL/4)%2)
   			where PART_NUMBER_2=1 and PART_NUMBER_1=0 and PLAYER_NUMBER_1=floor(floor((NEW.CHP_PRTCPNT_ID-1)/4)%2) and PLAYER_NUMBER_2=floor(floor((NEW.CHP_PRTCPNT_ID-1)/2)%2) and PLAYER_NUMBER_3=floor((NEW.CHP_PRTCPNT_ID-1)%2);
	end if;
    
    if(ifexists=0) then
		insert into OUTPUT_TO_DEMULTIPLEXER 
        values(floor(floor((NEW.CHP_PRTCPNT_ID-1)/4)%2),floor(floor((NEW.CHP_PRTCPNT_ID-1)/2)%2),floor((NEW.CHP_PRTCPNT_ID-1)%2),0,0,floor(floor(NEW.HEAD_VIB_LVL/4)%2),floor(floor(NEW.HEAD_VIB_LVL/2)%2),floor(NEW.HEAD_VIB_LVL%2));
		insert into OUTPUT_TO_DEMULTIPLEXER 
        values(floor(floor((NEW.CHP_PRTCPNT_ID-1)/4)%2),floor(floor((NEW.CHP_PRTCPNT_ID-1)/2)%2),floor((NEW.CHP_PRTCPNT_ID-1)%2),0,1,floor(floor(NEW.BODY_VIB_LVL/4)%2),floor(floor(NEW.BODY_VIB_LVL/2)%2),floor(NEW.BODY_VIB_LVL%2));
		
    end if;
			
    
end//

delete from output_to_demultiplexer;//
select * from output_to_demultiplexer;//
select * from chp_prtcpnt_game;//
update chp_prtcpnt_game
set head_vib_lvl=7,body_vib_lvl=7
where CHP_PRTCPNT_ID=3 or CHP_PRTCPNT_ID=1;//


select * from countguys;//
delete from countguys;//	
select * from CHR_CHRCTRS;//
    
create table countguys(counter int);// 	
select * from CHP_PRTCPNT_GAME;//


update CHP_PRTCPNT_GAME
set CHP_STATUS='Alive'
where CHP_PRTCPNT_ID=4;//


select * from EVT_EVENTS_OUTCOME;//
delete from EVT_EVENTS_OUTCOME;//
    
create table CHP_PRTCPNT_GAME (CHP_PRTPNT_GAME_ID int auto_increment primary key,CHP_PRTCPNT_ID  int, CHP_CHRCTR_ID int,  HIT_POINTS int, CHP_STATUS varchar(20), foreign key(CHP_PRTCPNT_ID) references PAR_PRTCPNT(PAR_PRTCPNT_ID), foreign key(CHP_CHRCTR_ID) references CHR_CHRCTRS(CHR_CHRCTR_ID));//
select * from CHP_PRTCPNT_GAME;//
insert into CHP_PRTCPNT_GAME values(1,1,1,0,0,100,'Alive');//
insert into CHP_PRTCPNT_GAME values(2,2,2,0,0,100,'Alive');//
insert into CHP_PRTCPNT_GAME values(3,3,3,0,0,100,'Alive');//
insert into CHP_PRTCPNT_GAME values(4,4,4,0,0,100,'Alive');//
insert into CHP_PRTCPNT_GAME values(5,5,5,0,0,100,'Alive');//
insert into CHP_PRTCPNT_GAME values(6,6,6,0,0,100,'Alive');//
insert into CHP_PRTCPNT_GAME values(7,7,7,0,0,100,'Alive');//
insert into CHP_PRTCPNT_GAME values(8,8,8,0,0,100,'Alive');//
delete from chp_prtcpnt_game;//
insert into EVT_EVENTS_SHOOT values(1,'Naveen',4,'Head');//
drop table EVT_EVENTS_SHOOT;//




create table EVT_EVENTS_SHOOT(PRTCPNT_ID int, PRTCPNT_NAME varchar(20), VBR_LVL int, VBR_AREA varchar(20));//
 select * from EVT_EVENTS_SHOOT;//
 delete from EVT_EVENTS_SHOOT;//

create table EVT_EVENTS_OUTCOME(TEAM_NAME varchar(20),RESULT varchar(20));//



call HITTED(100,100,100,100,@abc,@flag);//
select @abc;//
select @flag;//

drop table OUTPUT_TO_DEMULTIPLEXER;//

select * from CHP_PRTCPNT_GAME;//


select count(*) from OUTPUT_TO_DEMULTIPLEXER;//

insert into OUTPUT_TO_DEMULTIPLEXER values(0,0,0,0,0,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(0,0,0,0,1,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(0,0,0,1,1,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(0,0,0,1,0,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(0,0,1,0,0,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(0,0,1,0,1,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(0,0,1,1,1,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(0,0,1,1,0,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(0,1,0,0,0,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(0,1,0,0,1,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(0,1,0,1,1,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(0,1,0,1,0,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(0,1,1,0,0,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(0,1,1,0,1,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(0,1,1,1,1,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(0,1,1,1,0,0,0,0);//

insert into OUTPUT_TO_DEMULTIPLEXER values(1,0,0,0,0,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(1,0,0,0,1,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(1,0,0,1,1,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(1,0,0,1,0,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(1,0,1,0,0,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(1,0,1,0,1,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(1,0,1,1,1,0,0,0);//

insert into OUTPUT_TO_DEMULTIPLEXER values(1,0,1,1,0,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(1,1,0,0,0,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(1,1,0,0,1,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(1,1,0,1,1,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(1,1,0,1,0,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(1,1,1,0,0,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(1,1,1,0,1,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(1,1,1,1,1,0,0,0);//
insert into OUTPUT_TO_DEMULTIPLEXER values(1,1,1,1,0,0,0,0);//

delete from OUTPUT_TO_DEMULTIPLEXER;//


create table CHP_PRTCPNT_GAME (CHP_PRTPNT_GAME_ID int auto_increment primary key,CHP_PRTCPNT_ID  int, CHP_CHRCTR_ID int , HEAD_VIB_LVL int default 0,BODY_VIB_LVL int default 0, HIT_POINTS int, CHP_STATUS varchar(20), foreign key(CHP_PRTCPNT_ID) references PAR_PRTCPNT(PAR_PRTCPNT_ID), foreign key(CHP_CHRCTR_ID) references CHR_CHRCTRS(CHR_CHRCTR_ID));//


select floor(floor(floor(5/2)/2)%2),floor(floor(5/2)%2),floor(5%2) from OUTPUT_TO_DEMULTIPLEXER;//



drop table FUCKYOU;//
CREATE TABLE FUCKYOU LIKE CHP_PRTCPNT_GAME; //
INSERT FUCKYOU SELECT * FROM CHP_PRTCPNT_GAME;//

select * from CHP_PRTCPNT_GAME;//
select * from FUCKYOU;//

drop trigger vib;//
create trigger vib after update on FUCKYOU for each row
begin
    	update OUTPUT_TO_DEMULTIPLEXER
			set VIBRATION_LVL_3=floor(NEW.HEAD_VIB_LVL%2), VIBRATION_LVL_2=floor(floor(NEW.HEAD_VIB_LVL/2)%2),VIBRATION_LVL_1=floor(floor(NEW.HEAD_VIB_LVL/4)%2)
			where PART_NUMBER_2=0 and PART_NUMBER_1=0 and PLAYER_NUMBER_1=floor(floor((NEW.CHP_PRTCPNT_ID-1)/4)%2) and PLAYER_NUMBER_2=floor(floor((NEW.CHP_PRTCPNT_ID-1)/2)%2) and PLAYER_NUMBER_3=floor((NEW.CHP_PRTCPNT_ID-1)%2);
		update OUTPUT_TO_DEMULTIPLEXER
			set VIBRATION_LVL_3=floor(NEW.BODY_VIB_LVL%2), VIBRATION_LVL_2=floor(floor(NEW.BODY_VIB_LVL/2)%2),VIBRATION_LVL_1=floor(floor(NEW.BODY_VIB_LVL/4)%2)
   			where PART_NUMBER_2=1 and PART_NUMBER_1=0 and PLAYER_NUMBER_1=floor(floor((NEW.CHP_PRTCPNT_ID-1)/4)%2) and PLAYER_NUMBER_2=floor(floor((NEW.CHP_PRTCPNT_ID-1)/2)%2) and PLAYER_NUMBER_3=floor((NEW.CHP_PRTCPNT_ID-1)%2);
end//
delimiter ;

create table MOTHERFUCKER(aa int);

select * from FUCKYOU;
update FUCKYOU
set head_vib_lvl=7,body_vib_lvl=7
where CHP_PRTCPNT_ID=2 or CHP_PRTCPNT_ID=1;
select * from OUTPUT_TO_DEMULTIPLEXER;


update OUTPUT_TO_DEMULTIPLEXER
set VIBRATION_LVL_1=0,VIBRATION_LVL_2=0,VIBRATION_LVL_3=0;







drop database WEBPROJECT;
create database WEBPROJECT;
use WEBPROJECT;

select * from usertable;
select * from person;
select * from song;
select * from PaidSongs;



use VirtualRealityGaming;


select * from gen_genre;
select * from GAM_GAMES;


