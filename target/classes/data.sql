  insert into AppUsers(UserId, Username, FirstName, LastName, Email, Phone, Password)
    values (
    '1',
    'HALIX',
    'Halina',
    'Straszna',
    'halina@wp.pl',
    '7000',
    '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AQubh4a'
    );


  insert into authorities (Username, Authority)
    values ('HALIX', 'USER');
--login: user password: pass
  insert into AppUsers(UserId, Username, FirstName, LastName, Email, Phone, Password)
    values (
    '0',
    'user',
    'firstname',
    'lastname',
    'user@example.pl',
    '1000',
    '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AQubh4a'
    );





  insert into AppUsers(UserId, Username, FirstName, LastName, Email, Phone,Password,Enabled,AccountNonExpired,AccountNonLocked,CredentialsNonExpired)
    values (
    'delofonix',
    'delofonix',
    'Dariusz',
    'Fonnier',
    'delofonix@gmail.com',
    '12345',
    '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AQubh4a',
    '1',
    '1',
    '1',
    '1'

);

  insert into Authorities (Username, Authority)
    values ('delofonix', 'ADMIN');


  insert into Roles ( RoleName)
    values ( 'USER');
  insert into Roles ( RoleName)
    values ( 'ADMIN');

    insert into Pokemons(
      PokemonId ,PokedexIndex ,PokemonName ,NickName,Sex ,Weight ,      Height ,      PokemonType,      CombatPower ,     HealthPoints) values (
      'first',
      '1',
      'Bulbasaur',
      'Bulbasaur',
      'male',
      '6.9',
      '0.7',
      'Poison, Grass',
      '721',
      '88'
      )
