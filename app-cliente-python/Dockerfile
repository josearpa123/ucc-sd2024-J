FROM python:3.9.20-alpine3.19
WORKDIR /app
COPY requirements.txt /app
RUN pip install --no-cache-dir -r requirements.txt
COPY app.py /app
CMD ["python", "app.py"]