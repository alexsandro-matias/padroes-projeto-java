import { HttpGetParams, HttpResponse, HttpPostParams } from './types';

export interface HttpGetClient<R = any> {
    get(params: HttpGetParams): Promise<HttpResponse<R>>;
}
