# Serverless File Upload with AWS

## Description

This lab implements a **basic serverless architecture on AWS** to securely upload files to Amazon S3 using **pre-signed URLs**.

The objective is to demonstrate how to expose an HTTP API with **API Gateway**, execute backend logic using **AWS Lambda (Java)**, and store files in **Amazon S3** without exposing AWS credentials to the client.

This lab represents a **foundational serverless pattern**, commonly used in real-world AWS architectures.

---

## Problem Statement

Uploading files directly through a backend server is inefficient, costly, and does not scale well.

The challenge is to:
- Allow clients to upload files securely
- Avoid routing file content through the backend
- Keep the S3 bucket private
- Respect the principle of least privilege

---

## Solution Overview

The solution uses:
- **API Gateway** to expose an HTTP endpoint
- **AWS Lambda (Java)** to generate a pre-signed S3 URL
- **Amazon S3** to store files securely
- **IAM** to control access with minimal permissions

The client uploads the file **directly to S3** using a temporary, scoped URL.

---

## Architecture Diagram

![Serverless Upload Architecture](aws-serverless-upload/docs/serveless upload architecture.png)

---

## Architecture Flow

1. Client calls the API Gateway endpoint
2. API Gateway invokes the Lambda function
3. Lambda generates a pre-signed S3 PUT URL
4. Lambda returns the URL to the client
5. Client uploads the file directly to S3
6. The S3 bucket remains private

---

## AWS Services Used

- Amazon API Gateway (HTTP API)
- AWS Lambda (Java 17)
- Amazon S3
- AWS IAM

---

## Versions

- **v1-basic**  
  Basic serverless upload using API Gateway, Lambda, and S3

- **v2-with-terraform**  
  Same architecture deployed using Terraform (Infrastructure as Code)




