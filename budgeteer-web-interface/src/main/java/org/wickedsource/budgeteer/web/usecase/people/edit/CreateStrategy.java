package org.wickedsource.budgeteer.web.usecase.people.edit;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wickedsource.budgeteer.service.notification.Notification;
import org.wickedsource.budgeteer.service.people.PeopleService;
import org.wickedsource.budgeteer.web.usecase.people.edit.component.form.EditPersonForm;
import org.wickedsource.budgeteer.web.usecase.people.edit.component.notificationlist.EmptyPersonNotificationModel;
import org.wickedsource.budgeteer.web.usecase.people.edit.component.notificationlist.PersonNotificationList;

/**
 * Strategy to be used by EditPersonPage to CREATE a new person.
 */
public class CreateStrategy implements IEditPersonPageStrategy {

    @SpringBean
    private PeopleService service;

    private EditPersonPage page;

    private PageParameters backlinkParameters;

    private Class<? extends WebPage> backlinkPage;

    public CreateStrategy(EditPersonPage page, Class<? extends WebPage> backlinkPage, PageParameters backlinkParameters) {
        Injector.get().inject(this);
        this.backlinkPage = backlinkPage;
        this.backlinkParameters = backlinkParameters;
        this.page = page;
    }

    @Override
    public Label createPageTitleLabel(String id) {
        return new Label(id, new StringResourceModel("page.title.createmode", page, null));
    }

    @Override
    public Label createSubmitButtonLabel(String id) {
        return new Label(id, new StringResourceModel("button.save.createmode", page, null));
    }

    @Override
    public ListView<Notification> createNotificationListView(String id, long personId) {
        return new PersonNotificationList(id, new EmptyPersonNotificationModel());
    }

    @Override
    public EditPersonForm createForm(String id, long personId) {
        return new EditPersonForm(id, this);
    }

    @Override
    public Link createBacklink(String id) {
        return new Link(id) {
            @Override
            public void onClick() {
                setResponsePage(backlinkPage, backlinkParameters);
            }
        };
    }

    @Override
    public void goBack(){
        page.setResponsePage(backlinkPage, backlinkParameters);
    }
}