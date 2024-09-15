import { HttpGetParams, HttpResponse } from './types';

export interface HttpGetClient<R = any> {
    get(params: HttpGetParams): Promise<HttpResponse<R>>;
}
