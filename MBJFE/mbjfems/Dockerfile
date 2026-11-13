FROM node:26-alpine AS build
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build

FROM nginx:alpine
COPY nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=buiild /app/dist/mbjfems/browser /usr/share/nginx/html
EXPOSE 80
