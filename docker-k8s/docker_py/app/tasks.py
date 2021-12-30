from invoke import task

@task
def run(c):
    c.run('FLASK_APP=app:app flask db upgrade')
    c.run('FLASK_APP=app:app flask run -p 8000 -h 0.0.0.0')