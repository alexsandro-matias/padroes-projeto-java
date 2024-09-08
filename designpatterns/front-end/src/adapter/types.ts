import { HTTP_STATUS_CODE } from './enums';

export type HttpGetParams = {
    url: string;
    params?: any;
};

export type HttpResponse<R = any> = {
    statusCode: HTTP_STATUS_CODE;
    data?: R;
};

export type HttpPostParams<B = any> = {
    url: string;
    body?: B;
    params?: any;
};
