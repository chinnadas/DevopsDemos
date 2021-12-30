FROM python:3.8

WORKDIR /appsource
COPY ./ /appsource
RUN pip3 install -U pip poetry
RUN python3 -m poetry config virtualenvs.create false
RUN python3 -m poetry install

EXPOSE 8000
CMD ["invoke", "run"]