#!/bin/bash

# THIS IS FOR LOCAL USE AND TESTING ONLY
# DO NOT USE THIS SHELLSCRIPT IN ANY ACTUAL CI CD PIPELINE

trap 'echo >&2 "$_ at $LINENO"; exit $LINENO; sleep 5' ERR

if [ $# -eq 0 ] && [[ $1 != "-local" ]] && [[ $1 != "-staging" ]] && [[ $1 != "-production" ]]
  then
    echo -e "No valid argument supplied for build type i.e. -local, -staging, -production\nPlease supply a valid argument first\n"

else

  if [[ $1 == "-local" ]]
    then
      echo -e "\nBuilding .jar (Local)\n"
      echo -e "./gradlew buildApp -PmainClass=local \n"
      ./gradlew buildApp -PmainClass=local

      echo -e "\nBuilding Docker Image (Local)\n"
      docker build -t wynlo/springboot-boilerplate-local:latest .

  elif [[ $1 == "-staging" ]]
    then
      echo -e "\nBuilding .jar (Staging)\n"
      echo -e "./gradlew buildApp -PmainClass=staging \n"
      ./gradlew buildApp -PmainClass=staging

      echo -e "\nBuilding Docker Image (Staging)\n"
      docker build -t wynlo/springboot-boilerplate-staging:latest .

  elif [[ $1 == "-production" ]]
    then
      echo -e "\nBuilding .jar (Production)\n"
      echo -e "./gradlew buildApp -PmainClass=production \n"
      ./gradlew buildApp -PmainClass=production

      echo -e "\nBuilding Docker Image (Production)\n"
      docker build -t wynlo/springboot-boilerplate-production:latest .

  fi

fi

echo "Exiting in 5..."

sleep 5