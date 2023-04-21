# 1st Step to install npm 
FROM node:latest as build
WORKDIR /usr/local/app
COPY ./ /usr/local/app/
RUN npm install
RUN npm run build

# 2step to build angular
FROM nginx:latest
COPY --from=build /usr/local/app/dist/my-travel /usr/share/nginx/html
EXPOSE 80

