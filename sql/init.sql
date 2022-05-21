REVOKE ALL PRIVILEGES ON DATABASE dacatividadesete FROM dacatividadesete;
DROP DATABASE dacatividadesete;
DROP USER dacatividadesete;


CREATE DATABASE dacatividadesete;

CREATE USER dacatividadesete WITH PASSWORD 'dacatividadesete';

GRANT ALL PRIVILEGES ON DATABASE dacatividadesete TO dacatividadesete;
