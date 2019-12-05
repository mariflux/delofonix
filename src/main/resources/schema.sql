 drop table Authorities;
 drop table AppUsers;
 drop table Roles;
 drop table Pokemons;

   CREATE TABLE AppUsers (
    UserId VARCHAR(50) NOT NULL,
    Username VARCHAR(50),
    SapUsername VARCHAR(50),
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Email VARCHAR(50),
    Phone VARCHAR(50),
    Password VARCHAR(250),
    Enabled TINYINT NOT NULL DEFAULT 1,
    AccountNonExpired TINYINT NOT NULL DEFAULT 1,
    AccountNonLocked TINYINT NOT NULL DEFAULT 1,
    CredentialsNonExpired TINYINT NOT NULL DEFAULT 1,
    PRIMARY KEY (UserId)
  );


  CREATE TABLE Authorities (
    Username VARCHAR(50) NOT NULL,
    Authority VARCHAR(350) NOT NULL,
    FOREIGN KEY (Username) REFERENCES AppUsers(Username)
  );

  CREATE UNIQUE INDEX ix_auth_user on Authorities (Username,authority);

  CREATE TABLE Roles (
    RoleName VARCHAR(350) NOT NULL
  );

  CREATE TABLE Pokemons(
      PokemonId VARCHAR(350) NOT NULL,
      PokedexIndex NUMBER,
      PokemonName VARCHAR(350),
      NickName VARCHAR(350),
      Sex VARCHAR(350),
      Weight NUMBER,
      Height NUMBER,
      PokemonType VARCHAR(350),
      CombatPower NUMBER,
      HealthPoints NUMBER
      );

