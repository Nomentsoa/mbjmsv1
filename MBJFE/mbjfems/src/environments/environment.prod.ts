export const environment = {
  production: true,
  apiUrl: (window as any)["env"]?.["apiUrl"] || 'http://laza3:8080/api',
};
