import { HTTP_STATUS_CODE } from '@/entities/http-status-code';

export interface AdapterResponse<R = any> {
    statusCode: HTTP_STATUS_CODE;
    data?: R;
}
