INSERT INTO roles (role_id, role_name) VALUES (1, 'BASIC')
ON DUPLICATE KEY UPDATE role_id = role_id;

SELECT 'data.sql executed' AS message;