import psycopg2
import time
import random

DB_URL = "host=localhost port=5433 dbname=maindb user=postgres password=postgres"

def main():
    conn = psycopg2.connect(DB_URL)
    cursor = conn.cursor()
    try:
        while True:
            wait_time = random.randint(1, 10)  # Espera aleatoria entre 1 y 10 segundos
            time.sleep(wait_time)
            cursor.execute("SELECT id, name FROM dummy_table")
            results = cursor.fetchall()
            for row in results:
                print(f'Python Resultado: is: {row[0]}, name: {row[1]}')  # Muestra tanto el id como el nombre
    except Exception as e:
        print(f'Error: {e}')
    finally:
        cursor.close()
        conn.close()

if __name__ == "__main__":
    main()
