export const environment = {
  production: true,
  apiUrl: (window as any)["env"]?.["apiUrl"] || 'http://locaasdfalhost:8080/api',
};
