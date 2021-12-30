"""Create a table for ToDos

Revision ID: 2c20a9f3dae4
Revises: 
Create Date: 2021-03-30 10:17:08.368566

"""
from alembic import op
import sqlalchemy as sa


# revision identifiers, used by Alembic.
revision = '2c20a9f3dae4'
down_revision = None
branch_labels = None
depends_on = None


def upgrade():
    op.create_table('todo',
    sa.Column('id', sa.Integer(), nullable=False),
    sa.Column('text', sa.String(length=200), nullable=True),
    sa.Column('complete', sa.Boolean(), nullable=True),
    sa.PrimaryKeyConstraint('id')
    )


def downgrade():
    op.drop_table('todo')
