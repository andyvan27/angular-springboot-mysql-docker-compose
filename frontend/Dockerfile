FROM node:18.12.1-alpine AS build
WORKDIR /usr/src/app
COPY package.json ./
RUN npm install
COPY . .
RUN npm run build

FROM nginx:1.23.3-alpine-slim
COPY default.conf /etc/nginx/conf.d/default.conf
COPY --from=build /usr/src/app/dist/employeemanagerapp /usr/share/nginx/html
EXPOSE 80