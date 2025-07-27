import axios from 'redaxios';

export class AxiosFactory {
  public static getAxios() {
    return axios.create({
      baseURL: 'http://localhost/api',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
    });
  }
}
