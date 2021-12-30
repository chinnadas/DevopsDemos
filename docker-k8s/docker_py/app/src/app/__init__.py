from pathlib import Path
import os

from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate

# for local testing
current_dir = Path(__file__).parent
default_db_uri = f'sqlite:///{(current_dir.parent.parent / "todo.db").absolute()}'

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = os.environ.get(
    'DATABASE_URI', default_db_uri
)
db = SQLAlchemy(app)
migrate = Migrate(app, db, directory=str((current_dir / 'migrations').absolute()))
  
from app import routes
