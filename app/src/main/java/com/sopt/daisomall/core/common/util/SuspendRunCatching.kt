package com.sopt.daisomall.core.common.util

import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlin.coroutines.cancellation.CancellationException

/**
 * suspend 함수를 안전하게 실행하고 결과를 [Result]로 반환합니다.
 *
 * [runCatching]과 달리 코루틴 취소를 [Result]로 감싸지 않고 다시 던져 전파합니다.
 * [block] 내부에서 발생한 [TimeoutCancellationException]은 실패로 간주하지만,
 * 호출한 코루틴이 취소된 경우(바깥 타임아웃 포함)에는 취소를 전파합니다.
 *
 * @param block 실행할 suspend 블록
 * @return 성공 시 [Result.success], [block]에서 예외가 발생하면 [Result.failure]
 * @throws CancellationException 호출한 코루틴이 취소된 경우
 */

suspend fun <R> suspendRunCatching(block: suspend () -> R): Result<R> {
    return try {
        Result.success(block())
    } catch (t: TimeoutCancellationException) {
        currentCoroutineContext().ensureActive()
        Result.failure(t)
    } catch (c: CancellationException) {
        throw c
    } catch (e: Exception) {
        currentCoroutineContext().ensureActive()
        Result.failure(e)
    }
}
