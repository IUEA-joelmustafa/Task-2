#!/bin/bash
ENVIRONMENT=$1
JAR=$(ls target/*.jar 2>/dev/null | head -1)
echo "=== Deployment Script ==="
echo "Environment: $ENVIRONMENT"
echo "Artifact: $JAR"
echo "Host: $(hostname)"
if [ -z "$JAR" ]; then
  echo "ERROR: No JAR file found!"
  exit 1
fi
mkdir -p ~/deployments/$ENVIRONMENT
cp $JAR ~/deployments/$ENVIRONMENT/
echo "=== Deployed to ~/deployments/$ENVIRONMENT ==="
echo "=== Deployment SUCCESSFUL ==="
