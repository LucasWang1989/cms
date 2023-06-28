CREATE TABLE cms_user_info (
  F_ID INT AUTO_INCREMENT PRIMARY KEY,
  F_USERNAME VARCHAR(50) UNIQUE KEY,
  F_EMAIL VARCHAR(100) NOT NULL,
  F_PASSWORD VARCHAR(100) NOT NULL,
  F_CREATED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  F_UPDATED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
