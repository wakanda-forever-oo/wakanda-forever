package wakandaforever.wakandaforever.async;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import wakandaforever.wakandaforever.async.base.SchedulerProvider;

public class SyncSchedulerProvider implements SchedulerProvider {
    @Override
    public Scheduler background() {
        return Schedulers.trampoline();
    }

    @Override
    public Scheduler ui() {
        return Schedulers.trampoline();
    }
}

