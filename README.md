<h1>Endterm-project</h1>
<hr>
<p>This project focuses on developing an online Transfer Window System. 
   The main aim is to create a Transfer Window System that has a lot of functions, so clubs can see information about themselves and their budgets. 
   Also, they are able to transfer money to another club. Furhermore, there is another club, which is admin. Every club(simple club or admin) can see their account information.</p>

<h2>Classes:</h2>
<hr>
<h3>Entities:</h3>

<li>class Clubs - this class is responsible for creating an object Club and storing information about club. It contains variables 'clubname', 'password', 'club_type' (club or admin), 'country'.</li>

<li>class Budget - this class is responsible for creating an object Budget and storing information about clubs' budgets. It contains variables 'id', 'clubname', 'money_amount', 'valuta'.</li>
<li>class Transfers - this class is responsible for creating an object Transfers and storing information about transfer. It contains variables 'id', 'date', 'from_clubname', 'to_clubname', 'money_transferred'.</li>

<h3>Repositories:</h3>
<li>class ClubRepository - this class is responsible for creating an object ClubRepository. It contains methods 'getClubByClubname' - to get user by clubname from database; and 'createClub' - to add a new club into database.</li>
<li>class BudgetRepository - this class is responsible for creating an object BudgetRepository. It contains methods 'createBudgetForClubname' - to add a new budget for clubname into database; 'getBudgetByClubname' - to get budget by clubname from database; 'depositMoney' - to update(increase) money of club in database. It is needed in transfering money from one club to one club.</li>
<li>class TransferRepository - this class is responsible for creating an object BudgetRepository. It contains methods 'getTransfersByClubname' - to get transfer history of one user; 'createTransfer' - add a new transfer into database.</li>

<h3>Controllers:</h3>
<li>class ClubController - this class is responsible for creating an object ClassController and control whole functions of applicaton. It contains methods 'getClub', 'createClub', 'getClubInfo', 'transferMoney'.</li>

<h3>Data:</h3>
<li>class DB - this class is responsible for creating an object DB and to connect with database.</li>

<h2>PostgreSQL:</h2>
CREATE TABLE users(
	username VARCHAR(255),
	password VARCHAR(255),
	user_type BOOL,
	full_name VARCHAR(255),
	address VARCHAR(255),
	PRIMARY KEY(username)
);

CREATE TABLE cards(
id SERIAL,
username VARCHAR(255),
money INT,
number VARCHAR(255),
PRIMARY KEY(id),
FOREIGN KEY(username) REFERENCES users(username)
);

CREATE TABLE transactions(
id SERIAL,
date DATE,
from_username VARCHAR(255),
to_username VARCHAR(255),
money INT,
PRIMARY KEY(id),
FOREIGN KEY(from_username) REFERENCES users(username),
FOREIGN KEY(to_username) REFERENCES users(username)
);

INSERT INTO clubs (clubname, password, club_type, country) VALUES ('Real_Madrid' , 'CR7' , '0' , 'Spain');
INSERT INTO clubs (clubname, password, club_type, country) VALUES ('PSG' , 'Neymar' , '0' , 'France');
INSERT INTO clubs (clubname, password, club_type, country) VALUES ('Barcelona' , 'LM10' , '0' , 'Spain');
INSERT INTO clubs (clubname, password, club_type, country) VALUES ('Liverpool' , 'MoSalah' , '0' , 'England');
INSERT INTO clubs (clubname, password, club_type, country) VALUES ('Bayern_Munich' , 'Lewa' , '0' , 'Germany');
INSERT INTO clubs (clubname, password, club_type, country) VALUES ('Manchester_City' , 'Pep' , '0' , 'England');
INSERT INTO clubs (clubname, password, club_type, country) VALUES ('Juventus' , 'Buffon' , '0' , 'Italy');
INSERT INTO clubs (clubname, password, club_type, country) VALUES ('MU' , 'DeGea' , '0' , 'England');
INSERT INTO clubs (clubname, password, club_type, country) VALUES ('Atletico' , 'Oblak' , '0' , 'Spain');
INSERT INTO clubs (clubname, password, club_type, country) VALUES ('FIFA' , 'Admin' , '1' , 'Kazakhstan');

INSERT INTO budget (clubname, money_amount, valuta) VALUES ('Real_Madrid', 100000000, 'Euro');
INSERT INTO budget (clubname, money_amount, valuta) VALUES ('PSG', 500000000, 'Euro');
INSERT INTO budget (clubname, money_amount, valuta) VALUES ('Barcelona', 50000000, 'Euro');
INSERT INTO budget (clubname, money_amount, valuta) VALUES ('Liverpool', 80000000, 'FSterling');
INSERT INTO budget (clubname, money_amount, valuta) VALUES ('Bayern_Munich', 150000000, 'Euro');
INSERT INTO budget (clubname, money_amount, valuta) VALUES ('Manchester_City', 500000000, 'FSterling');
INSERT INTO budget (clubname, money_amount, valuta) VALUES ('Juventus',  90000000, 'Euro');
INSERT INTO budget (clubname, money_amount, valuta) VALUES ('MU', 120000000, 'FSterling');
INSERT INTO budget (clubname, money_amount, valuta) VALUES ('Atletico', 75000000, 'Euro');
INSERT INTO budget (clubname, money_amount, valuta) VALUES ('FIFA', 999000000, 'Euro');

SELECT * FROM budget;

SELECT * FROM clubs;

<h2>Authors</h2>
<hr>

<li>Full name: Dias Nurbergenov. Arsen Tolebai</li>
<li>Group: SE-2001</li>
