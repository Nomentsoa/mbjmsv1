export const environment = {
  production: false,
  apiUrl: (window as any)["env"]?.["apiUrl"] || 'http://2.24.102.95:8080/api',
};
