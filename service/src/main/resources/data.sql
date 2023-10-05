insert into notifications.notification_templates (created_at, modified_at, version, name, subject, template)
values (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, 'account-confirmation', '👋😎[JustedlevHub] Confirmation', 'Welcome {FULL_NAME}!
Follow your individual link to confirm and activate your new account:

{CONFIRMATION_LINK}

Best regards,
{BEST_REGARDS_FROM}')
on conflict do nothing;

insert into notifications.notification_types (created_at, modified_at, version, label)
values (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, 'email'),
       (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, 'phone')
on conflict do nothing;