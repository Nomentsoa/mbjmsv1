export const environment = {
  production: false,
  apiUrl: (window as any)["env"]?.["apiUrl"] || 'http://laza2:8080/api',
};
