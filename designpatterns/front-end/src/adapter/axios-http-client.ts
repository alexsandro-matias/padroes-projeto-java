import axios, { AxiosResponse } from 'axios';
import { HttpGetClient } from './interface';
import { HttpGetParams, HttpResponse } from './types';

export class AxiosHttpClient implements HttpGetClient {
    async get<T = any>(params: HttpGetParams): Promise<HttpResponse<T>> {
        let response: AxiosResponse;

        try {
            response = await axios.get(params.url, { params: params.params });
        } catch (error) {
            response = error as AxiosResponse;
        }

        return {
            statusCode: response.request.status,
            data: response.data,
        };
    }
}
