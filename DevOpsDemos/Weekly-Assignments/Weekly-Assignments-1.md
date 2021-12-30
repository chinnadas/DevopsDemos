# Deploy VPC components to create private EC2 instance in AWS cloud

#### Assignment Description: 
Please create private EC2 instance with "t2.micro" type in AWS cloud and the required dependency resources to connect to the private EC2 server as per the architecture shown above.
#### Validation: 
Login to AWS EC2 instance deployed into Private Subnet.

#### Assignment Solution: 
1. Create a VPC with CIDR range 172.32.0.0/16
2. Create 2 Subnets ( One for public and another one for private) 
3. Create 2 Route tables (By default you get one route table. Create one more for private subnet)
4. Create an Internet Gateway and attach it to VPC 
5. Add Internet Gateway to public route table
6. Provision an EC2 instance on Each Subnet   
   `Note:` Instance provisioned under public subnet is called public EC2 instance and Instance provisioned under private subnet is called private EC2 instance.
7. Assign Elastic IP and Connect to public EC2 instance  
8. Copy keypair onto public EC2 instance and connect to private EC2 instance.
