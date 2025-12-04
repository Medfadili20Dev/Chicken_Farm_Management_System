CREATE TABLE IF NOT EXISTS users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Insert default admin user if not exists
INSERT OR IGNORE INTO users (username, name, email, password)
VALUES ('admin', 'Administrator', 'admin@farm.ma', 'admin123');