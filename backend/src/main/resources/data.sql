INSERT INTO roles (role_name) VALUES ('ROLE_USER')
ON DUPLICATE KEY UPDATE role_name = role_name;

SELECT 'data.sql executed' AS message;