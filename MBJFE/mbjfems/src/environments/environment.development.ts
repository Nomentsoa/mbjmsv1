export const environment = {
  production: false,
  apiUrl: (window as any)["env"]?.["apiUrl"] || 'https://lazanomentsoa.tech:8080/api',
};
