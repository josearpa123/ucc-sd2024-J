from fastapi import FastAPI
from sqlalchemy import create_engine, MetaData, Table, text
from sqlalchemy.orm import sessionmaker

DATABASE_URL = "postgresql://postgres:postgres@db/api"

engine = create_engine(DATABASE_URL)
metadata = MetaData()
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)

app = FastAPI()

@app.get("/data")
def read_data():
    with engine.connect() as connection:
        result = connection.execute(text("SELECT * FROM example"))
        data = [{"column1": row[0], "column2": row[1]} for row in result]
        return data